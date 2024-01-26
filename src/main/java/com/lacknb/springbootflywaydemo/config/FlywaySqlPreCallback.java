package com.lacknb.springbootflywaydemo.config;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.alter.Alter;
import net.sf.jsqlparser.statement.alter.AlterExpression;
import net.sf.jsqlparser.statement.alter.AlterOperation;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.truncate.Truncate;
import org.apache.commons.io.FileUtils;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * <h2> SQL 预检测 </h2>
 *
 * @description:
 * @menu
 * @author: gitsilence
 * @description:
 * @date: 2024/1/25 15:46
 **/
@Slf4j
public class FlywaySqlPreCallback implements Callback {

    @Override
    public boolean supports(Event event, Context context) {
        return Event.BEFORE_EACH_MIGRATE.equals(event);
    }

    @Override
    public boolean canHandleInTransaction(Event event, Context context) {
        return true;
    }

    @Override
    public void handle(Event event, Context context) {
        MigrationInfo migrationInfo = context.getMigrationInfo();
        if (migrationInfo == null) {
            return;
        }
        String abstractPath = migrationInfo.getPhysicalLocation();
        System.out.println(abstractPath);
        try {
            String content = FileUtils.readFileToString(new File(abstractPath), "UTF-8");

            String[] split = StringUtils.split(content, ";");
            for (String sql : split) {
                if (!StringUtils.hasText(sql)) {
                    continue;
                }
                if (checkHighRiskSql(sql)) {
                    throw new RuntimeException("SQL: " + sql + " 未通过安全验证 !");
                }
            }
        } catch (IOException e) {
            log.error("读取文件失败", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断 SQL 是否高危操作，是则返回true
     * @param sql
     * @return
     */
    private boolean checkHighRiskSql(String sql) {
        try {
            Statement st = CCJSqlParserUtil.parse(sql);
            if (st instanceof Alter) {
                Alter alter = (Alter) st;
                for (AlterExpression alterExpression : alter.getAlterExpressions()) {
                    AlterOperation operation = alterExpression.getOperation();
                    if (operation == AlterOperation.DROP) {
                        return true;
                    }
                }
            }
            return st instanceof Drop ||
                    st instanceof Delete ||
                    st instanceof Truncate;
        } catch (JSQLParserException e) {
            log.error("解析SQL失败", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getCallbackName() {
        return "自定义SQL预检查";
    }
}
