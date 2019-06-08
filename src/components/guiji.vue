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

        <baidu-map class="map"></baidu-map>
    </div>
</template>

<script>
import Vue from 'vue';
import axios from 'axios'
export default {
    name: 'guiji',
    data() {
        return {
            msg: '',
            startTime: '',
            endTime: ''
        }
    },
    methods: {
        search() {
        
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