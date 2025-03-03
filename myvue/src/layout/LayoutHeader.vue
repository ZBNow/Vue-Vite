<script setup>
    import { useStore } from 'vuex'
    import { useRouter } from 'vue-router'
    const store = useStore();
    const router = useRouter();
    const handleClear=()=>{
        store.commit('User/clearAll');
        router.push('/login');
    }
</script>
<template>
    <el-button @click="handleClear">清空</el-button>
</template>
<style scoped>

</style>