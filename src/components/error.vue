<template>
  <div >    
    <el-table style="margin-top: 30px;" :data="data"> 
          
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
