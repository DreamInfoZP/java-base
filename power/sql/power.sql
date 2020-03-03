-- 权限表
CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `mid` int(11) DEFAULT NULL COMMENT '资源id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- 菜单表
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  `url` varchar(255) DEFAULT NULL COMMENT '资源',
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `orderNum` int(255) DEFAULT NULL COMMENT '序号',
  `type` varchar(255) DEFAULT NULL COMMENT '功能类型  module : 模块  page:页面  button:功能',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
-- 角色表
CREATE TABLE `role` (
  `id` int(11) NOT NULL COMMENT '唯一id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `role_dbPrivilege` varchar(255) DEFAULT NULL COMMENT '数据库权限',
  `status` varchar(255) DEFAULT NULL COMMENT '角色状态 y:启用 n:禁用  默认y  如果角色被禁用 所有角色下的账号都不能使用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;