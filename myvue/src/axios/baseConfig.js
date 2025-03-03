//baseConfig.js文件是axios的基础配置，包含了请求地址、超时时间、请求头等信息。
const baseConfig = {
  baseURL: '/sands',      // 请求地址    
  timeout: 5000,                         // 超时时间
  headers: {
    'Content-Type': 'application/json;charset=UTF-8'   // 请求头
  },
  method: 'get',                        // 请求方法
  withCredentials: true,                 // 允许携带cookie
  responseType: 'json'                   // 返回数据类型
}
export default baseConfig;