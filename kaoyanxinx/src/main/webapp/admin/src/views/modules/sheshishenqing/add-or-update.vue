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
        <el-form-item  v-if="type!='info'"  label="设施名称" prop="sheshimingcheng">
          <el-input v-model="ruleForm.sheshimingcheng" 
              placeholder="设施名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.sheshimingcheng" label="设施名称" prop="sheshimingcheng">
              <el-input v-model="ruleForm.sheshimingcheng" 
                placeholder="设施名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="考生账号" prop="kaoshengzhanghao">
          <el-input v-model="ruleForm.kaoshengzhanghao" 
              placeholder="考生账号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.kaoshengzhanghao" label="考生账号" prop="kaoshengzhanghao">
              <el-input v-model="ruleForm.kaoshengzhanghao" 
                placeholder="考生账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="考生姓名" prop="kaoshengxingming">
          <el-input v-model="ruleForm.kaoshengxingming" 
              placeholder="考生姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.kaoshengxingming" label="考生姓名" prop="kaoshengxingming">
              <el-input v-model="ruleForm.kaoshengxingming" 
                placeholder="考生姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="导师工号" prop="daoshigonghao">
          <el-select  @change="daoshigonghaoChange" v-model="ruleForm.daoshigonghao" placeholder="请选择导师工号">
            <el-option
                v-for="(item,index) in daoshigonghaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.daoshigonghao" label="导师工号" prop="daoshigonghao">
              <el-input v-model="ruleForm.daoshigonghao" 
                placeholder="导师工号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="导师姓名" prop="daoshixingming">
          <el-input v-model="ruleForm.daoshixingming" 
              placeholder="导师姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.daoshixingming" label="导师姓名" prop="daoshixingming">
              <el-input v-model="ruleForm.daoshixingming" 
                placeholder="导师姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="申请日期" prop="shenqingriqi">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.shenqingriqi" 
                type="datetime"
                placeholder="申请日期">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shenqingriqi" label="申请日期" prop="shenqingriqi">
              <el-input v-model="ruleForm.shenqingriqi" 
                placeholder="申请日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                            </el-row>
                                      <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'" label="申请理由" prop="shenqingliyou">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="申请理由"
                  v-model="ruleForm.shenqingliyou">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.shenqingliyou" label="申请理由" prop="shenqingliyou">
                    <span>{{ruleForm.shenqingliyou}}</span>
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
                        sheshimingcheng: '',
                                shenqingliyou: '',
                                kaoshengzhanghao: '',
                                kaoshengxingming: '',
                                daoshigonghao: '',
                                daoshixingming: '',
                                shenqingriqi: '',
                                sfsh: '',
                                shhf: '',
                      },
                                                                                daoshigonghaoOptions: [],
                                                                            rules: {
                  sheshimingcheng: [
                                                                                              ],
                  shenqingliyou: [
                                                                                              ],
                  kaoshengzhanghao: [
                                                                                              ],
                  kaoshengxingming: [
                                                                                              ],
                  daoshigonghao: [
                                                                                              ],
                  daoshixingming: [
                                                                                              ],
                  shenqingriqi: [
                                                                                              ],
                  sfsh: [
                                                                                              ],
                  shhf: [
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
                    if(o=='sheshimingcheng'){
            this.ruleForm.sheshimingcheng = obj[o];
            continue;
          }
                    if(o=='shenqingliyou'){
            this.ruleForm.shenqingliyou = obj[o];
            continue;
          }
                    if(o=='kaoshengzhanghao'){
            this.ruleForm.kaoshengzhanghao = obj[o];
            continue;
          }
                    if(o=='kaoshengxingming'){
            this.ruleForm.kaoshengxingming = obj[o];
            continue;
          }
                    if(o=='daoshigonghao'){
            this.ruleForm.daoshigonghao = obj[o];
            continue;
          }
                    if(o=='daoshixingming'){
            this.ruleForm.daoshixingming = obj[o];
            continue;
          }
                    if(o=='shenqingriqi'){
            this.ruleForm.shenqingriqi = obj[o];
            continue;
          }
                    if(o=='sfsh'){
            this.ruleForm.sfsh = obj[o];
            continue;
          }
                    if(o=='shhf'){
            this.ruleForm.shhf = obj[o];
            continue;
          }
                  }
                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                this.ruleForm.kaoshengzhanghao = json.kaoshengzhanghao
                                                this.ruleForm.kaoshengxingming = json.kaoshengxingming
                                                                                                                                            } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                  this.$http({
              url: `option/daoshixinxi/daoshigonghao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.daoshigonghaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
                                                                                                    },
                                            // 下二随
    daoshigonghaoChange () {
      this.$http({
        url: `follow/daoshixinxi/daoshigonghao?columnValue=`+ this.ruleForm.daoshigonghao,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
                                                                                                                                                  if(data.data.daoshixingming){
                this.ruleForm.daoshixingming = data.data.daoshixingming
              }
                                                                                                } else {
          this.$message.error(data.msg);
        }
      });
    },
                                            // 多级联动参数
                                                                                                      info(id) {
      this.$http({
        url: `sheshishenqing/info/${id}`,
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
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `sheshishenqing/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.sheshishenqingCrossAddOrUpdateFlag = false;
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
      this.parent.sheshishenqingCrossAddOrUpdateFlag = false;
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
