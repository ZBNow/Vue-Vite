import axios from 'axios'
import baseConfig from './baseConfig.js'
import router from '../router/index.js'
//js文件中不能用vue规范的import语法，只能用require语法
const instance = axios.create({...baseConfig});  // 创建axios实例

// 请求拦截器,config是从instance.request()方法中传入的参数,可以对config做一些处理,比如设置headers,添加token等
//config初始值是从baseConfig中获取的
instance.interceptors.request.use(config => {
  // 在发送请求之前做些什么
  let token = localStorage.getItem('myvue_token');
  if (token) {
    config.headers.token = token;
  }else {
    router.push('/login');
  }
  return config
}, error => {
  // 对请求错误做些什么
  return Promise.reject(error)
})


// 响应拦截器
instance.interceptors.response.use(response => {
  // 对响应数据做点什么,数据解套，分析。
  if(response.data.code === 200){
    return response.data;
  }else if(response.data.code === -1){
    //token失效或者用户名错误
    router.push('/login');
  }else return Promise.reject(response.data.msg);
}, error => {
  // 对响应错误做点什么
  return Promise.reject(error)
})




export default instance      // 导出实例