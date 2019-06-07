<template>
  <div >
    <div class="error">
      <el-input v-model="msg" style="width: 400px;margin-right: 20px;" placeholder="请输入"></el-input>
      <el-button type="primary">查询</el-button>    

    </div>      
    <el-table style="margin-top: 40px;"> 
          
    </el-table>  
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'error',
  data() {
    return {
      msg: '',
      data: []
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
