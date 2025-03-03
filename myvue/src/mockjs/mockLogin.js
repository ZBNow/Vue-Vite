const users=[
    {
        username:'李华',
        password:'111'
    }
];
export const postlogin=(opt)=>{
    console.log(opt);
    console.log('拦截到login的post请求');
    let body=JSON.parse(opt.body);
    const {username,password} = body;
    console.log(username);
    console.log(password);
    let arr=users.filter(el=>el.username===username&&el.password===password);
    if(arr.length>0){
        return {
            code:200,
            msg:'成功',
            data:{
                username,
                token:username+'sjsdfhjfsdjvsdjfjsfsdfgshfk'
            }
        }
    }else{
        return{
            code:201,
            msg:'失败'
        }
    }
    
}
export const loginget=(opt)=>{
    console.log(opt);
    console.log('拦截到login的get请求');
    return{
        code:200,
        msg:'成功'
    }
}
export const register=(opt)=>{
    console.log(opt);
}