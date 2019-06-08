<template>
  <div >    
    <el-table border style="margin-top: 30px;" :data="data" height="450"> 
      <el-table-column label="eid" prop=""></el-table-column>
      <el-table-column label="time" prop=""></el-table-column>
      <el-table-column label="address" prop=""></el-table-column>
      <el-table-column label="longtitude" prop=""></el-table-column>
      <el-table-column label="latitude" prop=""></el-table-column>
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
  },
    methods: {
      async search() {
        
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
