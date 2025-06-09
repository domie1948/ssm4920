<template>
  <div>
    <img class="bg" src="@/assets/img/bg.jpg">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-form">
      <h1 class="h1">考研信息查询系统注册</h1>
                                                      <el-form-item v-if="tableName=='daoshixinxi'" label="导师工号" prop="daoshixinxidaoshigonghao">
        <el-input v-model="ruleForm.daoshigonghao" placeholder="导师工号"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='daoshixinxi'" label="密码" prop="daoshixinximima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='daoshixinxi'" label="导师姓名" prop="daoshixinxidaoshixingming">
        <el-input v-model="ruleForm.daoshixingming" placeholder="导师姓名"></el-input>
      </el-form-item>
                                          <el-form-item v-if="tableName=='daoshixinxi'" label="手机号" prop="daoshixinxishoujihao">
        <el-input v-model="ruleForm.shoujihao" placeholder="手机号"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='daoshixinxi'" label="导师职称" prop="daoshixinxidaoshizhicheng">
        <el-input v-model="ruleForm.daoshizhicheng" placeholder="导师职称"></el-input>
      </el-form-item>
                                          <el-form-item v-if="tableName=='daoshixinxi'" label="电子邮箱" prop="daoshixinxidianziyouxiang">
        <el-input v-model="ruleForm.dianziyouxiang" placeholder="电子邮箱"></el-input>
      </el-form-item>
                                                                  <el-form-item v-if="tableName=='kaoshengxinxi'" label="考生账号" prop="kaoshengxinxikaoshengzhanghao">
        <el-input v-model="ruleForm.kaoshengzhanghao" placeholder="考生账号"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='kaoshengxinxi'" label="密码" prop="kaoshengxinximima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='kaoshengxinxi'" label="考生姓名" prop="kaoshengxinxikaoshengxingming">
        <el-input v-model="ruleForm.kaoshengxingming" placeholder="考生姓名"></el-input>
      </el-form-item>
                                          <el-form-item v-if="tableName=='kaoshengxinxi'" label="年龄" prop="kaoshengxinxinianling">
        <el-input v-model="ruleForm.nianling" placeholder="年龄"></el-input>
      </el-form-item>
                                          <el-form-item v-if="tableName=='kaoshengxinxi'" label="手机号" prop="kaoshengxinxishoujihao">
        <el-input v-model="ruleForm.shoujihao" placeholder="手机号"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='kaoshengxinxi'" label="邮箱" prop="kaoshengxinxiyouxiang">
        <el-input v-model="ruleForm.youxiang" placeholder="邮箱"></el-input>
      </el-form-item>
                                                                                          <el-button @click="login()" class="btn-login" type="primary">注册</el-button>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
              },
      tableName:"",
      rules: {}
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 注册
    login() {
                                                      if((!this.ruleForm.daoshigonghao) && `daoshixinxi` == this.tableName){
        this.$message.error(`导师工号不能为空`);
        return
      }
                                                            if((!this.ruleForm.mima) && `daoshixinxi` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
                                                                                                                                                                              if(`daoshixinxi` == this.tableName && this.ruleForm.shoujihao&&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
        this.$message.error(`手机号应输入电话格式`);
        return
      }
                                                                                                                                                                  if(`daoshixinxi` == this.tableName && this.ruleForm.dianziyouxiang&&(!this.$validate.isEmail(this.ruleForm.dianziyouxiang))){
        this.$message.error(`电子邮箱应输入邮件格式`);
        return
      }
                                                                                                            if((!this.ruleForm.kaoshengzhanghao) && `kaoshengxinxi` == this.tableName){
        this.$message.error(`考生账号不能为空`);
        return
      }
                                                            if((!this.ruleForm.mima) && `kaoshengxinxi` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
                                                                                                                                                                  if(`kaoshengxinxi` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
        this.$message.error(`年龄应输入整数`);
        return
      }
                                                                                                                        if(`kaoshengxinxi` == this.tableName && this.ruleForm.shoujihao&&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
        this.$message.error(`手机号应输入电话格式`);
        return
      }
                                                                  if(`kaoshengxinxi` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮件格式`);
        return
      }
                                                                                                      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${this.tableName}/register`,
            method: "post",
            data:this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$router.replace({ path: "/login" });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
