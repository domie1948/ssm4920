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
        <el-form-item v-if="type!='info'" label="专业编号" prop="zhuanyebianhao">
            <el-input v-model="ruleForm.zhuanyebianhao" 
                placeholder="专业编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhuanyebianhao" label="专业编号" prop="zhuanyebianhao">
              <el-input v-model="ruleForm.zhuanyebianhao" 
                placeholder="专业编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="专业名称" prop="zhuanyemingcheng">
          <el-input v-model="ruleForm.zhuanyemingcheng" 
              placeholder="专业名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhuanyemingcheng" label="专业名称" prop="zhuanyemingcheng">
              <el-input v-model="ruleForm.zhuanyemingcheng" 
                placeholder="专业名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="tupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tupian" label="图片" prop="tupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="专业注意事项" prop="zhuanyezhuyishixiang">
          <el-input v-model="ruleForm.zhuanyezhuyishixiang" 
              placeholder="专业注意事项" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhuanyezhuyishixiang" label="专业注意事项" prop="zhuanyezhuyishixiang">
              <el-input v-model="ruleForm.zhuanyezhuyishixiang" 
                placeholder="专业注意事项" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="专业类型" prop="zhuanyeleixing">
          <el-input v-model="ruleForm.zhuanyeleixing" 
              placeholder="专业类型" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhuanyeleixing" label="专业类型" prop="zhuanyeleixing">
              <el-input v-model="ruleForm.zhuanyeleixing" 
                placeholder="专业类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        </el-row>
                                                                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="专业介绍" prop="zhuanyejieshao">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.zhuanyejieshao" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.zhuanyejieshao" label="专业介绍" prop="zhuanyejieshao">
                    <span v-html="ruleForm.zhuanyejieshao"></span>
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
                        zhuanyebianhao: this.getUUID(),
                                zhuanyemingcheng: '',
                                tupian: '',
                                zhuanyejieshao: '',
                                zhuanyezhuyishixiang: '',
                                zhuanyeleixing: '',
                      },
                                                                                                rules: {
                  zhuanyebianhao: [
                                                                                              ],
                  zhuanyemingcheng: [
                                                                                              ],
                  tupian: [
                                                                                              ],
                  zhuanyejieshao: [
                                                                                              ],
                  zhuanyezhuyishixiang: [
                                                                                              ],
                  zhuanyeleixing: [
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
                    if(o=='zhuanyebianhao'){
            this.ruleForm.zhuanyebianhao = obj[o];
            continue;
          }
                    if(o=='zhuanyemingcheng'){
            this.ruleForm.zhuanyemingcheng = obj[o];
            continue;
          }
                    if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
            continue;
          }
                    if(o=='zhuanyejieshao'){
            this.ruleForm.zhuanyejieshao = obj[o];
            continue;
          }
                    if(o=='zhuanyezhuyishixiang'){
            this.ruleForm.zhuanyezhuyishixiang = obj[o];
            continue;
          }
                    if(o=='zhuanyeleixing'){
            this.ruleForm.zhuanyeleixing = obj[o];
            continue;
          }
                  }
                                                                                                              }
                                                                                                                                          },
                                                        // 多级联动参数
                                                                        info(id) {
      this.$http({
        url: `zhuanyexinxi/info/${id}`,
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
                              // ${column.compare}
                                                                                                                                                this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `zhuanyexinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.zhuanyexinxiCrossAddOrUpdateFlag = false;
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
      this.parent.zhuanyexinxiCrossAddOrUpdateFlag = false;
    },
                                                tupianUploadChange(fileUrls) {
                this.ruleForm.tupian = fileUrls;
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
