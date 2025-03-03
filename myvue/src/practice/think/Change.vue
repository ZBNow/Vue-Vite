<script setup>
import { changeCurrent, TID } from './ThinkData';
import {changeRequestQuestion} from '@/axios/requestThink.js';

const handleMyReturn=()=>{
    //修改ThinkData.js中的showNo=1
    // showNo.value=1;
    changeCurrent('HomeThink')
}
const form=ref({
    id:TID.value,
    LMC:'',
    title:'',
});

const changeQuestion=()=>{
    let question={type:'change',LMC:form.value.LMC,id:form.value.id,title:form.value.title};
    console.log("changeQuestion",question);
    changeRequestQuestion(question).then(res=>{
        if(res.code===200){
            console.log("success");
            changeCurrent('HomeThink');
        }
    }).catch(err=>{
        console.log(err);
    });
}
</script>

<template>
  <div class="page-container">
        <div class="title-container">
        <span>修改题目</span>
        </div>
        <div class="toolbar-container">
            <el-form :inline="true" :model="form" class="demo-form-inline">
                <el-form-item label="id">
                    <el-input
                        v-model="form.id"
                        style="width: 240px"
                        :rows="2"
                        type="textarea"
                        placeholder="id cannot be modified"
                        Editable="false"
                        disabled="true"
                    />
                </el-form-item>
                <el-form-item label="LMC">
                    <el-input
                        v-model="form.LMC"
                        style="width: 240px"
                        :rows="2"
                        type="textarea"
                        placeholder="Please input"
                    />
                </el-form-item>
                <el-form-item label="title">
                    <el-input
                        v-model="form.title"
                        style="width: 240px"
                        :rows="2"
                        type="textarea"
                        placeholder="Please input"
                    />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="changeQuestion">确定</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleMyReturn">取消</el-button>
                </el-form-item>

            </el-form>
        </div>
    </div>
</template>

<style scoped>
/* 这里可以添加一些样式来美化页面，但在这个简化版中没有添加 */
</style>