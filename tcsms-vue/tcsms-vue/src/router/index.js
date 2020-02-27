import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Welcome from '../views/Welcome'
import Index from '../views/Index'
import Page404 from '../views/Page404'

Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome,
      meta: {
        title: '欢迎页',
        requireAuth: false // 是否需要判断是否登录
      }

    },
    {
      path: '/auth/login',
      name: 'Login',
      component: Login,
      meta: {
        title: '登录',
        requireAuth: false
      }
    },
    {
      path: '/index',
      name: 'Index',
      component: Index,
      meta: {
        title: '首页',
        requireAuth: true
      }
    },
    {
      path: '/404',
      name: '404',
      component: Page404,
      meta: {
        title: '404',
        requireAuth: false
      }
    },
  ]
});
