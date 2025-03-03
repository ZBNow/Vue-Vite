import {createRouter, createWebHistory} from 'vue-router'
import store from '../store/index.js'
const childrenHomeFrame=[
    {
        path:'/thinkhome',
        name:'ThinkFrame',
        component:()=>import('@/practice/think/ThinkFrame.vue'),
        meta:{requireAuth:true}
    },
    {
        path:'/softhome',
        name:'HomeSoft',
        component:()=>import('@/practice/HomeSoft.vue'),
        meta:{requireAuth:true}
    },
    {
        path:'/hardhome',
        name:'HomeHard',
        component:()=>import('@/practice/HomeHard.vue'),
        meta:{requireAuth:true}
    },
    {
        path:'/testhome',
        name:'HomeTest',
        component:()=>import('@/test/HomeTest.vue'),
        meta:{requireAuth:true}
    },
    {
        path:'/pageframehome',
        name:'HomePageFrame',
        component:()=>import('@/layout/PageFrame.vue'),
        meta:{requireAuth:true}
    },
];
const routes=[
    {
        path:'/login',
        component:()=>import('@/components/LoginView.vue'),
        name:'LoginView',
        meta:{
            requireAuth:false,
            myname:'hello'
        }
    },
    {
        path:'/',
        component:()=>import('@/layout/HomeFrame.vue'),
        name:'HomeFrame',
        meta:{
            requireAuth:true,
            myname:'hello'
        },
        children:childrenHomeFrame
    },
    {
        path:'/register',
        meta:{
            requireAuth:false,
            myname:'hello'
        },
        component:()=>import('@/components/RegisterView.vue')
    }
]
const router=createRouter({
    routes,
    //history模式
    history:createWebHistory(import.meta.env.BASE_URL)
    //hash模式
    //createWebHashHistory(import.meta.env.BASE.URL)
    //如果用脚手架参数为process.env.BASE.URL
})
router.beforeEach((to,from)=>{
    if(to.meta.requireAuth===true){//路由需要认证
        if(store.getters['User/isLogin']===false){
            return {name:'LoginView'};//如果没有登录，跳转到登录页面
        }
        else return true;//放行，进入to.path页面
    }
    else return true;
})
export default router;