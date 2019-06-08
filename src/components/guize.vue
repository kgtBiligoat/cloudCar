<template>
    <div>
        <div class="error">
            <el-date-picker
                v-model="startTime"
                type="datetime"
                placeholder="选择开始时间"
                style="margin-right: 20px;"
            >
            </el-date-picker>
            <el-date-picker
                v-model="endTime"
                type="datetime"
                placeholder="选择结束时间"
                style="margin-right: 20px;"
            >
            </el-date-picker>
            <el-input v-model="msg" style="width: 200px;margin-right: 20px;" placeholder="请输入"></el-input>
            <el-button type="primary" @click="search">查询</el-button>            
        </div>

        <el-table :data="data"></el-table>
    </div>
</template>

<script>
import Vue from 'vue';
import axios from 'axios'
export default {
    name: 'guize',
    data() {
        return {
            startTime: '',
            endTime: '',
            msg: '',
            data: []
        }
    },
    methods: {
        search() {
            console.log(2)
            console.log(this.getTime(this.startTime))
        },
        getTime(time) {
            var y = time.getFullYear();  
            var m = time.getMonth() + 1;  
            m = m < 10 ? ('0' + m) : m;  
            var d = time.getDate();  
            d = d < 10 ? ('0' + d) : d;  
            var h = time.getHours();  
            var minute = time.getMinutes();  
            minute = minute < 10 ? ('0' + minute) : minute; 
            var second= time.getSeconds();  
            second = minute < 10 ? ('0' + second) : second;  
            return y + '-' + m + '-' + d+' '+h+':'+minute+':'+ second;  
        }
    }
}
</script>

<style >
.map {
  width: 100%;
  height: 300px;
}
.error {
  display: flex;
  flex-direction: row;
  margin-top: 20px;
  justify-content: center;
  margin-bottom: 20px;
}
</style>