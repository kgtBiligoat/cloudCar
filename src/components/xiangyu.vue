<template>
    <div>
    <div class="error">
      <el-input v-model="msg" style="width: 400px;margin-right: 20px;" placeholder="请输入eid"></el-input>
      <el-button type="primary" @click="search">查询</el-button>    

    </div>      
    <el-table border style="margin-top: 30px;" :data="data" height="450"> 
      <el-table-column label="eid1" prop="eid1"></el-table-column>
      <el-table-column label="eid2" prop="eid2"></el-table-column>
      <el-table-column label="number" prop="number"></el-table-column> 
    </el-table>  
    </div>
</template>

<script>
import Vue from 'vue';
import axios from 'axios'
export default {
    name: 'xiangyu',
    data() {
        return {
          msg: '',
          data: []
        }
    },
    methods: {
        async search() {
          let data = await axios.get('/api/', {
            params: {
              eid: this.eid
            }
          })

          console.log(data)
          this.data = data.data.data
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