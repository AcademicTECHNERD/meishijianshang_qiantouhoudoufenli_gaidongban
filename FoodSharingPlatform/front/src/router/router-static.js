// src/router/index.js

import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

// 页面组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import Pay from '@/views/pay'
import Register from '@/views/register'
import Center from '@/views/center'

// 模块列表
import MeishiList from '@/views/modules/meishijianshang/list'
import YonghuList from '@/views/modules/yonghu/list'
import DiscussList from '@/views/modules/discussmeishijianshang/list'
import StoreupList from '@/views/modules/storeup/list'
import ConfigList from '@/views/modules/config/list'
import FriendsList from '@/views/modules/wodehaoyou/list'

// 配置路由表
const routes = [
  {
    path: '/',
    component: Index,
    children: [
      {
        path: '',
        name: 'Home',
        component: Home,
        meta: { title: '首页' }
      },
      {
        path: 'updatePassword',
        name: 'UpdatePassword',
        component: UpdatePassword,
        meta: { title: '修改密码' }
      },
      {
        path: 'pay',
        name: 'Pay',
        component: Pay,
        meta: { title: '支付' }
      },
      {
        path: 'center',
        name: 'Center',
        component: Center,
        meta: { title: '个人信息' }
      },
      {
        path: 'meishijianshang',
        name: 'MeishiList',
        component: MeishiList,
        meta: { title: '美食鉴赏' }
      },
      {
        path: 'yonghu',
        name: 'YonghuList',
        component: YonghuList,
        meta: { title: '用户管理' }
      },
      {
        path: 'discussmeishijianshang',
        name: 'DiscussList',
        component: DiscussList,
        meta: { title: '美食鉴赏评论' }
      },
      {
        path: 'storeup',
        name: 'StoreupList',
        component: StoreupList,
        meta: { title: '我的收藏' }
      },
      {
        path: 'config',
        name: 'ConfigList',
        component: ConfigList,
        meta: { title: '轮播图管理' }
      },
      {
        path: 'wodehaoyou',
        name: 'FriendsList',
        component: FriendsList,
        meta: { title: '我的好友' }
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '*',
    name: 'NotFound',
    component: NotFound
  }
]

// 创建 Router 实例
const router = new VueRouter({
  mode: 'hash', // 或 'history'
  routes
})

// 修复 NavigationDuplicated 报错（全局处理 push/replace）
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location, onResolve, onReject) {
  if (onResolve || onReject) {
    return originalPush.call(this, location, onResolve, onReject)
  }
  return originalPush.call(this, location).catch(err => {
    if (err.name !== 'NavigationDuplicated') {
      return Promise.reject(err)
    }
    return err
  })
}

const originalReplace = VueRouter.prototype.replace
VueRouter.prototype.replace = function replace(location, onResolve, onReject) {
  if (onResolve || onReject) {
    return originalReplace.call(this, location, onResolve, onReject)
  }
  return originalReplace.call(this, location).catch(err => {
    if (err.name !== 'NavigationDuplicated') {
      return Promise.reject(err)
    }
    return err
  })
}

export default router
