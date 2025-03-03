import { createApp } from 'vue'
//或者import * as X from 'vue'
//再用X.createApp引用该函数
//import './style.css'
import App from './App.vue'
//import  './mockjs/index.js'
import store from './store/index.js';
import router from './router/index.js'
const obj=createApp(App);
obj.use(router).use(store).mount('#app')//链式调用
/*
    const xapp=createApp(App);//const保证xapp内存的地址不变
    xapp.mount('#app')
*/
import * as ElIcons from "@element-plus/icons-vue";
for (const name in ElIcons) {
   obj.component(name, ElIcons[name]);
}

