<script setup>
    //setup组合式api
    import {ref} from 'vue';
    let x=10;
    let arr=[2,4.5,'hello',y];//数组
    let b={
        first:"john",
        last:"doe",
        age:50,
        setage(){this.age=60;}
    }//对象
    
    const y=ref(0);
    //响应式状态，通过ref()函数实现，或者是reactive实现
    /*
        ref()的应用方式
        import {ref} from 'vue'
        const x1=ref(0)
        const x2=ref(true)
        const x3=ref([])
        const x4=ref('hello')
        const x5=ref({
            username:'',
            password:''
        })
        ref()通过把变量转化成显示对象的value成员,
        在页面脚本中要用.value来改变变量的值，在页面模版中，ref()自动解包，不需要用.value
        reactive()只能应用于对象
        const x=reactive({})
    */
   /*
    解构：
        let a=[1,2,3];
        let aa=[2,...a];
        即let aa=[2,1,2,3];
        let b={x:1,y:2};
        let bb={z:3,...b};
        即bb={z:3,x:1,y:2}
   */
  //promise对象
    function m1(c,d){
        return c+d;
    }
    //函数第一种方法
    const m2=()=>{
        y.value++;
    }
    //函数第二种方法
    let s='button';
</script>

<template>
    <button type="button" class="button" @click="m2">
        <!--@click=''里可以是个界符，可以是表达式，也可以是函数-->
        count is {{ y }}
        <!--双大括号只是把y解释成纯文本，只能用于标签体内，不能用于标签属性-->
    </button>
    <button :type="s" class="button" @click="m2">
        <!--
            ':'是属性绑定v-bind的简写，使用后可以将s的值赋给属性，s也可以是表达式
            :disabaled='2+4'意为将6赋给disabled属性
        -->
        count is {{ y }}
    </button>
</template>

<style lang="css" scoped></style>