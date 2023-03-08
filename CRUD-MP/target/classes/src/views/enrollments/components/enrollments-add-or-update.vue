<template>
  <el-dialog
    :title="title"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="200px">
    <el-form-item label="" prop="studentId">
      <el-input v-model="dataForm.studentId" placeholder="" />
    </el-form-item>
    <el-form-item label="" prop="courseId">
      <el-input v-model="dataForm.courseId" placeholder="" />
    </el-form-item>
    <el-form-item label="" prop="enrollDate">
      <el-input v-model="dataForm.enrollDate" placeholder="" />
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
import { saveOrder, updateOrder } from '@/api/enrollments/enrollments'

export default {
  data () {
    return {
      visible: false,
      title: '创建',
      dataForm: {
          id: 0,
          studentId: '',
          courseId: '',
          enrollDate: ''
      },
      dataRule: {
          studentId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          courseId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          enrollDate: [
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
