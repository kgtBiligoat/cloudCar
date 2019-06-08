<template>
    <div>
    <div class="error">
      <el-input v-model="msg" style="width: 400px;margin-right: 20px;" placeholder="请输入placeid"></el-input>
      <el-button type="primary" @click="search">查询</el-button>    

    </div>      
    <el-table border style="margin-top: 30px;" :data="data"> 
          
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
        async search() {
            let data = await axios.get('/api/count', {
                params: {
                    placeId: this.msg
                }
            }) 

            console.log(data)
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