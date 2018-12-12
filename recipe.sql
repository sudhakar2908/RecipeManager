CREATE TABLE `recipe` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `ingredient1` varchar(60),
  `ingredient2` varchar(60),
  `ingredient3` varchar(60),
  `ingredient4` varchar(60),
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_recipe_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
