// 定义某个表的querySchema
// schema的结构和含义参考下面的例子
// 注意: 所有的key不能重复

module.exports = [
  {
    key: 'userId',  // 传递给后端的字段名
    title: 'ID',  // 前端显示的名称
    dataType: 'int',
  },
  {
    key: 'userName',
    title: '用户名',
    dataType: 'varchar',
  },
  {
    key: 'userPassword',
    title: '密码',
    dataType: 'varchar',
  },
  {
    key: 'userAdministrative',
    title: '管理权限',
    dataType: 'int',
  },
];
