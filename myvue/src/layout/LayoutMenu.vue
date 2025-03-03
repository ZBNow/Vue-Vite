<script lang="ts" setup>
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
import { unique } from 'element-plus/es/utils/arrays.mjs';
import { useRouter } from 'vue-router';
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const router=useRouter();
const sub=[
  {
    index:'1',
    icon:'Lock',
    title:'课程实训',
    children:[
      {
        index:'1-1',
        path:'/thinkhome',
        title:'计算思维',
      },
      {
        index:'1-2',
        path:'/softhome',
        title:'软件开发',
      },
      {
        index:'1-3',
        path:'/hardhome',
        title:'硬件开发',
      }
    ]
  },
  {
    index:'2',
    icon:'Lock',
    title:'专业实习',
    children:[
      {
        index:'2-1',
        path:'/hardhome',
        title:'集中实训',
      },
      {
        index:'2-2',
        path:'/hardhome',
        title:'企业实习',
      }
    ]
  },
  {
    index:'3',
    icon:'Lock',
    title:'毕业设计',
    children:[
      {
        index:'3-1',
        path:'/hardhome',
        title:'选题申报',
      },
      {
        index:'3-2',
        path:'/hardhome',
        title:'开题答辩',
      },
      {
        index:'3-3',
        path:'/hardhome',
        title:'过程指导',
      },
      {
        index:'3-4',
        path:'/hardhome',
        title:'论文撰写',
      },
      {
        index:'3-5',
        path:'/hardhome',
        title:'论文答辩',
      },
      {
        index:'3-6',
        path:'/hardhome',
        title:'论文提交',
      }
    ]
  },
  {
    index:'4',
    icon:"Lock",
    path:'/testhome',
    title:'临时测试',
  },
  {
    index:'5',
    icon:"Lock",
    title:'系统管理',
    children:[
      {
        index:'5-1',
        path:'/hardhome',
        title:'思维题库',
      },

    ]
  }
]

</script>


<template>
    <el-col :span="24" >
      <el-menu
        active-text-color="blue"
        background-color="#fff"
        class="el-menu-vertical-demo"
        default-active="2"
        text-color="#000"
        :router="true"
        :unique-opened='false'
        @open="handleOpen"
        @close="handleClose"
      ><template v-for="(sub) in sub" :key="sub.index">
          <el-sub-menu  v-if="!!sub.children"  :index="sub.index">
              <template #title>
                  <el-icon>
                      <component :is="sub.icon"></component>
                  </el-icon>
                  <span>{{sub.title}}</span>
              </template>
              <el-menu-item v-for="(children) in sub.children" :key="children.index" :index="children.index"
                :route="children.path">{{children.title}}
              </el-menu-item>
          </el-sub-menu>
          <el-menu-item v-else :index="sub.index" :route="sub.path">
              <el-icon>
                  <component :is="sub.icon"></component>
              </el-icon>
              <span>{{ sub.title }}</span>
          </el-menu-item>
      </template>



        <el-menu-item index="6">
          <el-icon><icon-menu /></el-icon>
          <span>Navigator Two</span>
        </el-menu-item>
        <el-menu-item index="7" disabled>
          <el-icon><document /></el-icon>
          <span>Navigator Three</span>
        </el-menu-item>
        <el-menu-item index="8">
          <el-icon><setting /></el-icon>
          <span>Navigator Four</span>
        </el-menu-item>
      </el-menu>
    </el-col>
</template>


<style scoped>

</style>