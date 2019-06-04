<template>
  <div id="app">
    <el-container>
      <el-header>
        <img src="./assets/logo.png" style="width: 40px;height:25px; position: relative; top: 10px; left: -600px;">
        <span style="position: relative; top: 3px; left: -600px;">
          <span>云计算课程</span>  
          <span>SE</span>
          <span>5035</span>
        </span>

      </el-header>
      <el-container>
        <el-aside width="200px" style="height: 700px;">
           <el-menu
            default-active="1"
            class="el-menu-vertical-demo"
            style="height: 100%;"
          >
            <el-menu-item index="1">
              <span slot="title">项目介绍</span>
            </el-menu-item>
            <el-menu-item index="2">
              <span slot="title">车辆统计</span>
            </el-menu-item>
            <el-menu-item index="3">
              <span slot="title">轨迹重现</span>
            </el-menu-item>
            <el-menu-item index="4">
              <span slot="title">错误报警</span>
            </el-menu-item>
            <el-menu-item index="5">
              <span slot="title">相遇次数</span>
            </el-menu-item>
          </el-menu>`
        </el-aside>
        <el-main style="height: 700px;">Main</el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// import headerBar from './components/header.vue'
// import siderBar from './components/sideberBar' 
export default {
  name: 'App',
  components: {
    headerBar,
    siderBar
  }
}
</script>

<style>
html,body,#app{
  height: 100%;
  width: 100%;
}
body {
  margin: 0px;
}
.el-header{
  background-color: #343a40!important;
  color: white;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  height: 100%;;
  background-color: #f8f9fa!important;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  height: 100%;;
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

</style>
