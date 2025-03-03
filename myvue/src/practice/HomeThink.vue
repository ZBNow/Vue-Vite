<script setup>

import {options,getQureyquestions,changeRequestQuestion,requestFresh} from '@/axios/requestThink.js';
import { changeCurrent,TID } from './think/ThinkData';
import { computed, onMounted,  ref } from 'vue'
 
/*const handleDelete = (row, index) => {
    //post请求删除数据,传入数据row(列)，传回res(结构参考mock文件)(res:[code:200,msg:'获取delete成功'])
    postHandleDelete(row).then(res=>{
        if(res.code===200){
            console.log(res.msg)
            tableData.value.splice(index, 1);
            //array.splice(index,howmany,item1,.....,itemX)
            //index:规定从何处添加/删除元素,howmany:删除/添加几个元素,item1,.....,itemX:要添加/删除的元素
        }
    }).catch();
}*/
const deleteQuestion=(row, index)=>{
    let question={
        type:'delete',
        id:row.id,
        };
    console.log("deleteQuestion",question);
    changeRequestQuestion(question).then(res=>{
        console.log(res);
        if(res.code===200){       
            console.log("success");
            freshPageData();
        }
    }).catch(err=>{
        console.log(err);
    });
    
}



//computed是vue的计算属性，是根据依赖关系进行缓存的计算，只有在它的相关依赖发生改变时才会进行更新
//当一个数据受多个数据影响时，可以使用computed
const LMC=computed(()=>{
    if(form.value.chapters)return form.value.lmcc;
    else if(form.value.moudels)return form.value.lmcm;
    else return form.value.lmcl;
})
//table数据
const tableData=ref([])
//查询提交
const onSubmit = () => { 
    getQureyquestions(LMC.value).then(res=>{
        if(res.code===200){
            tableData.value=[...res.data.DB];
        }
    }).catch(err=>{ })
}



//选择器选中项的值
const form=ref({
    levels:'',//等级
    moudels:'',//模块
    chapters:'',//章节
    lmcl:'',//L只有一段
    lmcm:'',//两
    lmcc:''
});
//选择器的选项数组
const levels = ref([]);
const moudels=ref([]);
const chapters=ref([]);
onMounted(() => {
    //使用axios或instance请求后台数据
    options().then((res)=>{
        if(res.code===200){
            levels.value=[...res.data.options];
           // res.data.options[0].label='hh';
        }
    }).catch((err)=>{
        console.log(err);
    })
    freshPageData();
})
const levelchoose=(item)=>{
    form.value.levels=item;
    form.value.moudels='';
    form.value.chapters='';
    moudels.value=[...form.value.levels.children];
    form.value.lmcl=item.value;
}
const moudelchoose=(item)=>{
    form.value.moudels=item;
    form.value.chapters='';
    chapters.value=[...form.value.moudels.children];
    form.value.lmcm=item.value;
}
const chapterchoose=(item)=>{
    form.value.chapters=item;
    form.value.lmcc=item.value;
}

const levelchange=()=>{
    if(form.value.levels!==form.value.lmcl){
        form.value.moudels='';
        form.value.chapters='';
        moudels.value=[];
        chapters.value=[];
    }
}
const moudelchange=()=>{
    if(!form.value.moudels!==form.value.lmcm){
        form.value.chapters='';
        chapters.value=[];
    }
}
const handleMyJobs=()=>{
    //动态组件
    // showNo.value=2;
    changeCurrent('ThinkMyJobs')
    //修改ThinkFrame.vue中的current
}
const handleEdit=(row, index)=>{
    //修改数据
    //修改tableData.value[index]
    //修改页面显示
    TID.value=row.id;
    changeCurrent('Change');
}

const handleAdd=()=>{
    //修改数据
    //修改tableData.value[index]
    //修改页面显示
    changeCurrent('Add');
}
const page=ref({
    currentPage:1,
    pageSize:10,
    total:400,
    pageCount:''
})

const freshPageData=()=>{
    let data={type:'think',LMC:LMC.value};
    let {currentPage,pageSize}=page.value;
    data={currentPage,pageSize,...data};
    //console.log(data);
    requestFresh(data).then(res=>{
        if(res.code===200){
            page.value.total=res.data.total;
            tableData.value=[...res.data.tableData];
            console.log(tableData);
        }
    }).catch(err=>{});
}
</script>

<template>
    <div class="page-container">
        <div class="title-container">
        <span>计算思维</span>
        </div>
        <div class="toolbar-container">
            <el-form :inline="true" :model="form" class="demo-form-inline">
                <el-form-item>
                    <el-button type="primary" @click="handleMyJobs()">我的作业</el-button>
                </el-form-item>
                <el-form-item label="等级">
                     <el-select
                         v-model="form.levels"
                         placeholder=""
                         clearable @change="levelchange">
                        <el-option v-for="(item, index) in levels" :key="index" :label="item.label" :value="item.value" @click="levelchoose(item)"/>
                    </el-select>
                </el-form-item>
                <el-form-item label="模块">
                     <el-select
                         v-model="form.moudels"
                         placeholder=""
                         clearable @change="moudelchange">
                         <el-option v-for="(item, index) in moudels" :key="index" :label="item.label" :value="item.value" @click="moudelchoose(item)"/>
                    </el-select>
                </el-form-item>
                <el-form-item label="章节">
                     <el-select
                         v-model="form.chapters"
                         placeholder=""
                         clearable>
                         <el-option v-for="(item, index) in chapters" :key="index" :label="item.label" :value="item.value" @click="chapterchoose(item)"/>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="freshPageData">Query</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">Add</el-button>
                </el-form-item>
            </el-form>
        </div>
        <div class="content-container">
            <el-table :data="tableData" style="width: 100%">
                <el-table-column fixed prop="LMC" label="LMC" width="150" />
                <el-table-column prop="id" label="Id" width="120" />
                <el-table-column prop="title" label="Title" width="200" />
                <el-table-column prop="pass" label="Pass" width="120" />
                <el-table-column prop="submit" label="Submit" width="120" />
                <el-table-column prop="pdfString" label="PdfString" width="200" />
                <el-table-column fixed="right" label="Operations" min-width="120">
                    <template v-slot="scope">
                        <el-button type="primary" size="small" @click="handleEdit(scope.row, scope.$index)">修改</el-button>
                        <el-button  type="primary" size="small" @click="deleteQuestion(scope.row, scope.$index)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="divpage">
                <el-pagination
                    v-model:current-page="page.currentPage"
                    v-model:page-size="page.pageSize"
                    :background="true"
                    :page-sizes="[10, 20, 30, 40, 50]"
                    :current-page="page.currentPage"
                    :page-size="page.pageSize"
                    :total="page.total"
                    layout="total, sizes, prev, pager, next, jumper"
                    @current-change="freshPageData"
                >
                </el-pagination>
            </div>
        </div>
    </div>
</template>
<style scoped>
.page-container {
    height: 98%;
    overflow: hidden;
    background-color: #f0f8ff; /* 浅蓝色背景 */
    margin: 2px;
    border-color: #87CEFA; /* 天蓝色边框 */
    display: flex;
    flex-direction: column;
    justify-content: center;
    border-radius: 15px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
}

.title-container {
    height: 50px;
    background-color: #FFD700; /* 金色背景 */
    display: flex;
    justify-content: center;
    align-items: center;
    border-bottom: 2px solid #FFA500; /* 橙色下边框 */
}

.title-container > span {
    font-size: 24px;
    font-weight: bold;
    font-family: '隶书';
    color: #333; /* 深灰色文字 */
}

.toolbar-container {
    height: 50px;
    background-color: #ADD8E6; /* 浅蓝色背景 */
    display: flex;
    padding-top: 15px;
    padding-left: 15px;
    align-items: center;
    border-bottom: 1px solid #87CEFA; /* 天蓝色下边框 */
}

.content-container {
    height: 100%;
    background-color: white;
    flex: 1;
    border: 3px solid #87CEFA; /* 天蓝色边框 */
    overflow: auto;
    padding: 15px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
}

.divpage {
    margin-top: 10px;
    display: flex;
    justify-content: center;
}

.demo-form-inline .el-input {
    --el-input-width: 220px;
    border-radius: 5px; /* 输入框圆角 */
    background-color: #FFF; /* 白色背景 */
    border: 1px solid #87CEFA; /* 天蓝色边框 */
}

.demo-form-inline .el-select {
    --el-select-width: 220px;
    border-radius: 5px; /* 下拉框圆角 */
    background-color: #FFF; /* 白色背景 */
    border: 1px solid #87CEFA; /* 天蓝色边框 */
}

.demo-form-inline .el-button {
    border-radius: 5px; /* 按钮圆角 */
    background-color: #00BFFF; /* 深天蓝色背景 */
    color: #FFF; /* 白色文字 */
    border: none; /* 无边框 */
    margin-left: 10px; /* 按钮间距 */
}

.demo-form-inline .el-button:hover {
    background-color: #0096FF; /* 鼠标悬停时的颜色变化 */
}

.el-table {
    border-radius: 5px; /* 表格圆角 */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
}

.el-pagination {
    background-color: #f0f8ff; /* 浅蓝色背景 */
    border-radius: 5px; /* 分页器圆角 */
    padding: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
}
</style>