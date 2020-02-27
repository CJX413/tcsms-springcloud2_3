<template>
  <el-container>
    <el-header style="padding: 0">
      <el-menu
        @select="headerHandleSelect"
        class="el-menu-demo"
        mode="horizontal"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b" style="height: inherit">
        <el-row>
          <el-col :span="1" :offset="18">
            <el-menu-item index="1">
              <el-badge :value="3" class="item">
                <i class="el-icon-message" style="font-size: 25px;"></i></el-badge>
            </el-menu-item>
          </el-col>
          <el-col :span="3">
            <el-submenu index="2">
              <template slot="title">
                <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                <span>{{this.userInfo.name}}</span>
              </template>
              <el-menu-item index="2-1">
                <i class="el-icon-user-solid"></i>
                <span>个人信息</span>
              </el-menu-item>
              <el-menu-item index="2-2">
                <i class="el-icon-edit"></i>
                <span>完善信息</span>
              </el-menu-item>
              <el-menu-item index="2-3">
                <i class="el-icon-switch-button"></i>
                <span>注销</span>
              </el-menu-item>
            </el-submenu>
          </el-col>
          <el-col :span="2">
            <el-menu-item index="3">
              <el-link type="primary" href="">管理系统</el-link>
            </el-menu-item>
          </el-col>
        </el-row>
      </el-menu>
    </el-header>
    <el-divider></el-divider>
    <el-container>
      <el-aside width="200px">
        <el-menu
          default-active="1"
          class="el-menu-vertical-demo"
          @select="asideHandleSelect" style="text-align: left">
          <el-menu-item index="1">
            <i class="el-icon-location"></i>
            <span>设备位置</span>
          </el-menu-item>
          <el-menu-item index="2">
            <i class="el-icon-view"></i>
            <span>视频监控</span>
          </el-menu-item>
          <el-menu-item index="3">
            <i class="el-icon-coordinate"></i>
            <span>注册驾驶员</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-s-custom"></i>
            <span>注册监控员</span>
          </el-menu-item>
          <el-menu-item index="5">
            <i class="el-icon-video-camera-solid"></i>
            <span>监控回放</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main>
        <component v-bind:is="componentType" v-if="componentType==='user-info'" :userInfo="userInfo"></component>
        <component v-bind:is="componentType" v-else></component>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>


  export default {
    name: "Index",
    components: {
      DeviceLocation: () => import("../components/DeviceLocation.vue"),
      VideoMonitor: () => import("../components/VideoMonitor.vue"),
      UserInfo: () => import("../components/UserInfo.vue"),
    },
    data() {
      return {
        userInfo: {
          username: '',
          name: '',
          workerId: '',
          phoneNumber: '',
          sex: '',
        },
        componentType: 'device-location',
      };
    },
    mounted() {   //初始化页面要在mounted方法中调用自己也得初始化方法
      this.initPage();
    },
    methods: {
      initPage() {
        this.axios.post('http://localhost:8080/userInfo', {})
          .then((response) => {
            this.userInfo = response.data;
          });
      },
      headerHandleSelect(key) {
        console.log(key);
        switch (key) {
          case "1":
            this.componentType = '';
            break;
          case "2-1":
            this.componentType = 'user-info';
            break;
          case "2-2":
            break;
          case "2-3":
            break;
          case "3":
            break;
          default:
        }
      },
      asideHandleSelect(key) {
        console.log(key);
        switch (key) {
          case "1":
            this.componentType = 'device-location';
            break;
          case "2":
            this.componentType = 'video-monitor';
            break;
          case "3":
            break;
          case "4":
            break;
          case "5":
            break;
          default:
        }
      },
    }
  }
</script>
<style scoped>

</style>
