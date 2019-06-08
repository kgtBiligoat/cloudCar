<template>
    <div>
    <div class="error">
      <el-input v-model="msg" style="width: 400px;margin-right: 20px;" placeholder="请输入Eid"></el-input>
      <el-button type="primary" @click="search">查询</el-button>    

    </div>      
    <el-table style="margin-top: 30px;" :data="data"> 
          
    </el-table>  
    </div>
</template>
<script >
import Vue from 'vue';
import axios from 'axios'
export default {
    name: 'car',
    data() {
        return {
            msg: '',
            data: []
        }
    },
    methods: {
        search() {
        
        }
    }
}
</script>

<style scoped>
.error {
  display: flex;
  flex-direction: row;
  margin-top: 20px;
  justify-content: center;
}
</style>