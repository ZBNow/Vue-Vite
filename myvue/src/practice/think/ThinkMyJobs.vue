<script setup>
import { changeCurrent } from './ThinkData';
import {requestFresh} from '@/axios/requestThink.js';
const store = useStore();
const handleMyReturn=()=>{
    //修改ThinkData.js中的showNo=1
    // showNo.value=1;
    changeCurrent('HomeThink')
}
const filters=ref({
    username:'',
    id:'',
    state:''
});
const options=['全部','通过','未通过','编译错误','待提交'];

onMounted(()=>{
    freshPageData();
})
import {queryJobs} from "@/axios/requestThink.js"
import { onMounted } from 'vue';
const handleQuery=()=>{
    //根据查询条件，从后端服务器获取数据
    //查询条件：用户名，题号，状态数组，将来用in
    filters.value.username=store.getters['User/getUserName'];
    let {id,state,username}=filters.value;
    let {currentPage,pageSize}=page.value;
    let states=state==='全部'?['通过','未通过','编译错误','待提交']:[`${state}`];
     queryJobs({username,id,states,currentPage,pageSize}).then(res=>{
       if(res.code===200){
            tableData.value=res.data.tableData;
            tableProp.value=res.data.tableProp;
            page.value.total=res.data.total;
            console.log(tableData.value);
       }
    }).catch(err=>{
        console.log(err);
    })


}
const tableData=ref([])
const tableProp=ref([])
const handleEdit=(row,index)=>{

}
const handleDelete=(row,index)=>{

}
const page=ref({
    currentPage:1,
    pageSize:10,
    total:0
})

const freshPageData=()=>{
    let data={type:"jobs"};
    filters.value.username=store.getters['User/getUserName'];
    filters.value.username='admin'
    let {id,state,username}=filters.value;
    let {currentPage,pageSize}=page.value;
    let states=state==='全部'?['通过','未通过','编译错误','待提交']:[`${state}`];
    data={currentPage,pageSize,id,states,username,...data};
    console.log(data);
    requestFresh(data).then(res=>{
        if(res.code===200){
            console.log(res);
            tableProp.value=res.data.tableProp;
            page.value.total=res.data.total;
            console.log(tableData.value);
            tableData.value=[...res.data.tableData];
        }
    }).catch(err=>{});
}
</script>
<template>
    <div class="page-container">
        <div class="title-container">

        </div>
        <div class="toolbar-container">
            <el-form :inline="true" :model="form" class="demo-form-inline">
                <el-form-item>
                    <el-input v-model="filters.id" placeholder="题号"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-select v-model="filters.state"  placeholder="状态">
                        <el-option v-for="(item,index) in options" :key="index" :label="item" :value="item"/>                    
                    </el-select>
                </el-form-item>
                <!--查询-->
                <el-form-item>
                    <el-button  @click="freshPageData">查询</el-button>
                </el-form-item>
                
                <el-form-item>
                    <el-button  @click="handleMyReturn">首页</el-button>
                </el-form-item>
            </el-form>        
        </div>
        <div class="content-container">
            <el-table :data="tableData" style="width: 100%">
         
                <el-table-column v-for="item in tableProp" :key="item.prop" :prop="item.prop" :label="item.label" :width="item.width"/>
      
           
                <el-table-column fixed="right" label="Operations" min-width="120">
                    <template v-slot="scope">
                        <el-button type="primary" size="small" @click="handleEdit(scope.row, scope.$index)">修改</el-button>
                        <el-button type="primary" size="small" @click="handleDelete(scope.row, scope.$index)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="divpage">
                <el-pagination
                    v-model:current-page="page.currentPage"
                    v-model:page-size="page.pageSize"
                    :background="true"
                    :page-sizes="[10, 20, 30, 40, 50]"
            
                    :total="page.total"
                    layout="total,-> sizes, prev, pager, next, jumper"
                    @change="freshPageData"
                    :hide-on-single-page="true"
                >
                </el-pagination>
            </div>
        </div>
    </div>
</template>
<style scoped>
.page-container {
    height: 100%;
    overflow: hidden;
    background-color: aqua;
    margin: 2px;
    border-color: brown;
    display: flex;
    flex-direction: column;
    >.title-container{
        height: 50px;
        background-color: burlywood;
    }
    >.toolbar-container{
        height: 50px;
        background-color: cadetblue;
        display: flex;
        padding-top: 15px;
        padding-left: 15px;
        align-items: center;
    }
    >.content-container{
        height: 100%;
        background-color: white;
        flex: 1;
        border: 3px solid rgb(105, 201, 239);
        overflow: auto;
        >.divpage{
            margin-top: 10px;
            display: flex;
            justify-content: center;
        }
    }
    .demo-form-inline .el-input {
         --el-input-width: 220px;
    }

    .demo-form-inline .el-select {
    --el-select-width: 220px;
    }
}
</style>