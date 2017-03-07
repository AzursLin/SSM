module.exports = [
  {
    key: 'userId',
    title: 'ID',
    dataType: 'int',
    primary: true,
  },
  {
    key: 'userName',
    title: '用户名',
    dataType: 'varchar',
    validator: [{type: 'string', required: true, message: '用户名有误'}],
  },
  {
    key: 'userPassword',
    title: '密码',
    dataType: 'varchar',
    validator: [{type: 'string', required: true,message: '密码有误'}],
  },
  {
    key: 'userAdministrative',
    title: '管理权限',
    dataType: 'int',
    validator: [{type: 'int', required: true, message: '格式有误'}],
  },
];
