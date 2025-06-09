<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-row>
                  <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="学校名称" prop="xuexiaomingcheng">
          <el-input v-model="ruleForm.xuexiaomingcheng" 
              placeholder="学校名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xuexiaomingcheng" label="学校名称" prop="xuexiaomingcheng">
              <el-input v-model="ruleForm.xuexiaomingcheng" 
                placeholder="学校名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="学校图片" prop="xuexiaotupian">
          <file-upload
          tip="点击上传学校图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.xuexiaotupian?ruleForm.xuexiaotupian:''"
          @change="xuexiaotupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xuexiaotupian" label="学校图片" prop="xuexiaotupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.xuexiaotupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="学校地区" prop="xuexiaodiqu">
          <el-input v-model="ruleForm.xuexiaodiqu" 
              placeholder="学校地区" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xuexiaodiqu" label="学校地区" prop="xuexiaodiqu">
              <el-input v-model="ruleForm.xuexiaodiqu" 
                placeholder="学校地区" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          </el-row>
                                                    <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'" label="学校概况" prop="xuexiaogaikuang">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="学校概况"
                  v-model="ruleForm.xuexiaogaikuang">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.xuexiaogaikuang" label="学校概况" prop="xuexiaogaikuang">
                    <span>{{ruleForm.xuexiaogaikuang}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                                                                          <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="学校简介" prop="xuexiaojianjie">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.xuexiaojianjie" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.xuexiaojianjie" label="学校简介" prop="xuexiaojianjie">
                    <span v-html="ruleForm.xuexiaojianjie"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                    <el-form-item>
                <el-button v-if="type!='info'" type="primary" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
            ruleForm: {
                        xuexiaomingcheng: '',
                                xuexiaotupian: '',
                                xuexiaogaikuang: '',
                                xuexiaodiqu: '',
                                xuexiaojianjie: '',
                      },
                                                                                  rules: {
                  xuexiaomingcheng: [
                            { required: true, message: '学校名称不能为空', trigger: 'blur' },
                                                                                              ],
                  xuexiaotupian: [
                                                                                              ],
                  xuexiaogaikuang: [
                                                                                              ],
                  xuexiaodiqu: [
                                                                                              ],
                  xuexiaojianjie: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                  },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
                    if(o=='xuexiaomingcheng'){
            this.ruleForm.xuexiaomingcheng = obj[o];
            continue;
          }
                    if(o=='xuexiaotupian'){
            this.ruleForm.xuexiaotupian = obj[o];
            continue;
          }
                    if(o=='xuexiaogaikuang'){
            this.ruleForm.xuexiaogaikuang = obj[o];
            continue;
          }
                    if(o=='xuexiaodiqu'){
            this.ruleForm.xuexiaodiqu = obj[o];
            continue;
          }
                    if(o=='xuexiaojianjie'){
            this.ruleForm.xuexiaojianjie = obj[o];
            continue;
          }
                  }
                                                                                              }
                                                                                                                        },
                                                // 多级联动参数
                                                              info(id) {
      this.$http({
        url: `xuexiaojieshao/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                              this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `xuexiaojieshao/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.xuexiaojieshaoCrossAddOrUpdateFlag = false;
                  this.parent.search();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.xuexiaojieshaoCrossAddOrUpdateFlag = false;
    },
                                    xuexiaotupianUploadChange(fileUrls) {
                this.ruleForm.xuexiaotupian = fileUrls;
            },
                                                  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
</style>
