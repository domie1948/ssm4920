<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                                                      <el-col :span="12">
        <el-form-item  v-if="flag=='daoshixinxi'"  label="导师工号" prop="daoshigonghao">
          <el-input v-model="ruleForm.daoshigonghao" 
              placeholder="导师工号" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='daoshixinxi'"  label="密码" prop="mima">
          <el-input v-model="ruleForm.mima" 
              placeholder="密码" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='daoshixinxi'"  label="导师姓名" prop="daoshixingming">
          <el-input v-model="ruleForm.daoshixingming" 
              placeholder="导师姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="flag=='daoshixinxi'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="daoshixinxitouxiangUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='daoshixinxi'"  label="手机号" prop="shoujihao">
          <el-input v-model="ruleForm.shoujihao" 
              placeholder="手机号" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='daoshixinxi'"  label="导师职称" prop="daoshizhicheng">
          <el-input v-model="ruleForm.daoshizhicheng" 
              placeholder="导师职称" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='daoshixinxi'"  label="所在学校" prop="suozaixuexiao">
          <el-select v-model="ruleForm.suozaixuexiao" placeholder="请选择所在学校">
            <el-option
                v-for="(item,index) in daoshixinxisuozaixuexiaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='daoshixinxi'"  label="电子邮箱" prop="dianziyouxiang">
          <el-input v-model="ruleForm.dianziyouxiang" 
              placeholder="电子邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
                                                                  <el-col :span="12">
        <el-form-item  v-if="flag=='kaoshengxinxi'"  label="考生账号" prop="kaoshengzhanghao">
          <el-input v-model="ruleForm.kaoshengzhanghao" 
              placeholder="考生账号" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='kaoshengxinxi'"  label="密码" prop="mima">
          <el-input v-model="ruleForm.mima" 
              placeholder="密码" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='kaoshengxinxi'"  label="考生姓名" prop="kaoshengxingming">
          <el-input v-model="ruleForm.kaoshengxingming" 
              placeholder="考生姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='kaoshengxinxi'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in kaoshengxinxixingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='kaoshengxinxi'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling" 
              placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="flag=='kaoshengxinxi'" label="考生头像" prop="kaoshengtouxiang">
          <file-upload
          tip="点击上传考生头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.kaoshengtouxiang?ruleForm.kaoshengtouxiang:''"
          @change="kaoshengxinxikaoshengtouxiangUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='kaoshengxinxi'"  label="手机号" prop="shoujihao">
          <el-input v-model="ruleForm.shoujihao" 
              placeholder="手机号" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='kaoshengxinxi'"  label="邮箱" prop="youxiang">
          <el-input v-model="ruleForm.youxiang" 
              placeholder="邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
                                                                                          <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
                                                                                                                              daoshixinxisuozaixuexiaoOptions: [],
                                                                                                            kaoshengxinxixingbieOptions: [],
                                                                                                                                        };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                                                                                    this.$http({
      url: `option/xuexiaojieshao/xuexiaomingcheng`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.daoshixinxisuozaixuexiaoOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                                                                        this.kaoshengxinxixingbieOptions = "男,女".split(',')
                                                                                          },
  methods: {
                                                                                                                                                                                                                                                                                                daoshixinxitouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
                                                                                                                kaoshengxinxikaoshengtouxiangUploadChange(fileUrls) {
        this.ruleForm.kaoshengtouxiang = fileUrls;
    },
                                                                            onUpdateHandler() {
                                                      if((!this.ruleForm.daoshigonghao)&& 'daoshixinxi'==this.flag){
        this.$message.error('导师工号不能为空');
        return
      }
                                                            if((!this.ruleForm.mima)&& 'daoshixinxi'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                                                                                                                                              if( 'daoshixinxi' ==this.flag && this.ruleForm.shoujihao&&(!isMobile(this.ruleForm.shoujihao))){
        this.$message.error(`手机号应输入电话格式`);
        return
      }
                                                                                                                                                                  if( 'daoshixinxi' ==this.flag && this.ruleForm.dianziyouxiang&&(!isEmail(this.ruleForm.dianziyouxiang))){
        this.$message.error(`电子邮箱应输入邮箱格式`);
        return
      }
                                                                                                            if((!this.ruleForm.kaoshengzhanghao)&& 'kaoshengxinxi'==this.flag){
        this.$message.error('考生账号不能为空');
        return
      }
                                                            if((!this.ruleForm.mima)&& 'kaoshengxinxi'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                                                                                                                                  if( 'kaoshengxinxi' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
                                                                                                                        if( 'kaoshengxinxi' ==this.flag && this.ruleForm.shoujihao&&(!isMobile(this.ruleForm.shoujihao))){
        this.$message.error(`手机号应输入电话格式`);
        return
      }
                                                                  if( 'kaoshengxinxi' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
                                                                                                      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
