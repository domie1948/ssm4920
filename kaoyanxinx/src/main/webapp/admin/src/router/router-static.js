import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/shijuanliebiao/exam'
    import daoshixinxi from '@/views/modules/daoshixinxi/list'
    import sheshishenqing from '@/views/modules/sheshishenqing/list'
    import lunbotuguanli from '@/views/modules/lunbotuguanli/list'
    import kaoshengxinxi from '@/views/modules/kaoshengxinxi/list'
    import kefuguanli from '@/views/modules/kefuguanli/list'
    import zhuanyexinxi from '@/views/modules/zhuanyexinxi/list'
    import kaoyanzixun from '@/views/modules/kaoyanzixun/list'
    import xuexiaojieshao from '@/views/modules/xuexiaojieshao/list'
    import luntanguanli from '@/views/modules/luntanguanli/list'
    import xiangmuxinxi from '@/views/modules/xiangmuxinxi/list'

//2.配置路由   注意：名字
const routes = [
    {
        path: '/index', name:'index', component: Index, children: [{
            // 这里不设置值，是把main作为默认页面
            path: '/',
            name: 'home',
            component: Home
        },{
            path: '/updatePassword',
            name: 'updatePassword',
            component: UpdatePassword
        } ,{
            path: '/pay',
            name: 'pay',
            component: pay
        } ,{
            path: '/center',
            name: 'center',
            component: center
        } 
                    ,{
                path: '/daoshixinxi',
                name: 'daoshixinxi',
                component: daoshixinxi
            } 
                    ,{
                path: '/sheshishenqing',
                name: 'sheshishenqing',
                component: sheshishenqing
            } 
                    ,{
                path: '/lunbotuguanli',
                name: 'lunbotuguanli',
                component: lunbotuguanli
            } 
                    ,{
                path: '/kaoshengxinxi',
                name: 'kaoshengxinxi',
                component: kaoshengxinxi
            } 
                    ,{
                path: '/kefuguanli',
                name: 'kefuguanli',
                component: kefuguanli
            } 
                    ,{
                path: '/zhuanyexinxi',
                name: 'zhuanyexinxi',
                component: zhuanyexinxi
            } 
                    ,{
                path: '/kaoyanzixun',
                name: 'kaoyanzixun',
                component: kaoyanzixun
            } 
                    ,{
                path: '/xuexiaojieshao',
                name: 'xuexiaojieshao',
                component: xuexiaojieshao
            } 
                    ,{
                path: '/luntanguanli',
                name: 'luntanguanli',
                component: luntanguanli
            } 
                    ,{
                path: '/xiangmuxinxi',
                name: 'xiangmuxinxi',
                component: xiangmuxinxi
            } 
                ]
    },
    { path: '/adminexam', name: 'adminexam', component: adminexam },
    { path: '/login', name:'login', component: Login },
    { path: '/register', name:'register', component: register },
    { path: '/', redirect: '/index/' },      /*默认跳转路由*/
    { path: '*', component: NotFound }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
    mode: 'hash',   /*hash模式改为history*/
    routes // （缩写）相当于 routes: routes
})

export default router;

