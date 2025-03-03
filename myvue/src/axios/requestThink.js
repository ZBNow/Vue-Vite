import instance from "./instance";
export const options=()=>{
    return instance({
        url:'/lmc/options',
        method:'post',
    })
}
export const postQureyquestions=()=>{
    return instance({
        url:'/thinkhome/questions',
        method:'post'
    })
}
export const getQureyquestions=(lmc)=>{
    return instance({
        url:`/thinkhome/questions?LMC=${lmc}`,
        method:'get',
    })
}

export const postHandleDelete=(row,index)=>{
    return instance({
        url:'/thinkhome/delete',
        method:'post',
        data:{
            row,
            index
        }
    })
}
export const requestFresh=(data)=>{
    return instance({
        url:'lmc/fresh',
        method:'post',
        data,
    })
}
export const queryJobs=(data)=>{
    return instance({
        url:`/thinkhome/jobs/query`,
        method:'post',
        data,
    }) 
}

export const changeRequestQuestion=(data)=>{
    return instance({
        url:'/lmc/change',
        method:'post',
        data,
    })
}

