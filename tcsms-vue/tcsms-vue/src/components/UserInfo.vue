<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>{{userInfo.name}}</span>
    </div>
    <div class="text item">
      {{'用户名：' + userInfo.username }}
    </div>
    <div class="text item">
      {{'工号：' + userInfo.workerId }}
    </div>
    <div class="text item">
      {{'手机号：' + userInfo.phoneNumber }}
    </div>
    <div class="text item">
      {{'性别：' + userInfo.sex }}
    </div>
  </el-card>
</template>

<script>
  export default {
    name: "UserInfo",
    props: ['userInfo'],
  }
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
  }
</style>
