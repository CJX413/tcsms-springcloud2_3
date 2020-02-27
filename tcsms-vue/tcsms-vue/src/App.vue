<template>
  <div id="app">
    <router-view v-wechat-title="$route.meta.title"></router-view>
  </div>
</template>

<script>
  export default {
    name: 'App',
    created() {
      let token = localStorage.getItem('token');
      if (token !== null) {
        this.axios.post('http://localhost:8080/isLogin', {})
          .then((response) => {
            console.log(response);
            if (response.status === 200) {
              this.localSocket();
            } else {
              this.$router.push({path: '/auth/login'})
            }
          }).catch((error) => {
          console.log(error);
          next('/404');
        });
      }
    },
    methods: {
      localSocket() {
        let that = this;
        if ("WebSocket" in window) {
          console.log("您的浏览器支持 WebSocket!");

          that.ws = new WebSocket('ws://localhost:8080/webSocket/' + localStorage.getItem('token'));
          that.global.setWs(that.ws);
          that.ws.onopen = function () {
            //连接建立之后执行send方法发送数据
            console.log('websocket打开');
          };
          that.ws.onerror = function () {
            that.localSocket();
          };
          that.ws.onclose = function (e) {
            console.log('断开连接', e);
          };
        } else {
          // 浏览器不支持 WebSocket
          console.log("您的浏览器不支持 WebSocket!");
        }
      }
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 10px;
  }
</style>
