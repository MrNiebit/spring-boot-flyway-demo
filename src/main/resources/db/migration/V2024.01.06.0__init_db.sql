CREATE TABLE `v_user` (
                            `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                            `group_id` smallint(6) unsigned NOT NULL DEFAULT '0',
                            `user_name` varchar(30) NOT NULL DEFAULT '',
                            `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            `user_pwd` varchar(32) NOT NULL DEFAULT '',
                            PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;