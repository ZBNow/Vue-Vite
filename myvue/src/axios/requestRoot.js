import instance from "./instance";
export const login=(data)=>{
    return instance({
        url:'/login',
        method:'post',
        data:data
    })
}
export const register=(data)=>{
    return instance({
        url:'/register',
        method:'post',
        data:data
    })
}