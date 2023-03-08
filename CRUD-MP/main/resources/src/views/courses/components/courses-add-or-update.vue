<template>
  <el-dialog
    :title="title"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="200px">
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder="" />
    </el-form-item>
    <el-form-item label="" prop="description">
      <el-input v-model="dataForm.description" placeholder="" />
    </el-form-item>
    <el-form-item label="" prop="credit">
      <el-input v-model="dataForm.credit" placeholder="" />
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
import { saveOrder, updateOrder } from '@/api/courses/courses'

export default {
  data () {
    return {
      visible: false,
      title: '创建',
      dataForm: {
          id: 0,
          name: '',
          description: '',
          credit: ''
      },
      dataRule: {
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          credit: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
      }
    }
  },
  methods: {
    init (row) {
      this.visible = true
      this.title = '创建'
      this.$refs['dataForm'].resetFields()
      if (typeof row != 'undefined'){
        this.$nextTick(() => {
          this.dataForm = row
          this.title = '修改'
        })
      }
    },
    // 表单提交
    dataFormSubmit () {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          if (this.dataForm.id !== 0) {
            updateOrder(this.dataForm)
          } else {
            saveOrder(this.dataForm)
          }
          this.visible = false
        }
      })
    }
  }
}
</script>
