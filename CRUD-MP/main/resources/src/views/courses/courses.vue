<template>
  <div class="app-container">
    <div class="addRigon">
      <el-form :inline="true" :model="filter" @keyup.enter.native="fetch()">
        <el-form-item>
          <el-input v-model="filter.key" placeholder="参数名" clearable />
        </el-form-item>
        <el-form-item>
          <el-button @click="fetch()">查询</el-button>
          <el-button  type="primary" @click="addOrUpdateHandle()">新增</el-button>
          <el-button  type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="tableTitle">
      <el-table
        :data="dataSource"
        border
        v-loading="dataListLoading"
        @selection-change="selectionChangeHandle"
        style="width: 100%;">
          <el-table-column
            type="selection"
            header-align="center"
            align="center"
            width="50"
          />
                  <el-table-column
            prop="id"
            header-align="center"
            align="center"
            label=""
          />
                  <el-table-column
            prop="name"
            header-align="center"
            align="center"
            label=""
          />
                  <el-table-column
            prop="description"
            header-align="center"
            align="center"
            label=""
          />
                  <el-table-column
            prop="credit"
            header-align="center"
            align="center"
            label=""
          />
                  <el-table-column
            fixed="right"
            header-align="center"
            align="center"
            width="150"
            label="操作">
            <template slot-scope="scope">
              <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row)">修改</el-button>
              <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
      </el-table>
    </div>
    <el-pagination
            background
            layout="prev, pager, next"
            :page-size="pagination.size"
            :current-page="pagination.current"
            :total="pagination.total"
            @current-change="fetch"
    />
    <!-- 弹窗, 新增 / 修改 -->
    <AddOrUpdate v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="fetch" />
  </div>
</template>

<script>
  import AddOrUpdate from './components/courses-add-or-update'
  import { queryForPage, deleteCourses } from '@/api/courses/courses'

  export default {
    data () {
      return {
        filter: {
          key: ''
        },
        dataSource: [],
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false,
        pagination: {
          current: 1,
          size: 10,
          total: 0
        }
      }
    },
    components: {
      AddOrUpdate
    },
    created () {
      this.fetch()
    },
    methods: {
      // 获取数据列表
      async fetch (e) {
        if (typeof e === 'number') {
          this.pagination.current = e
        }
        const { pagination, filter } = this
        const params = { ...filter, ...pagination }
        const res = await queryForPage(params)
        console.log(res)
        const data = res.data
        this.dataSource = data.records
        const { current, size, total } = data
        this.pagination = { current, size, total }
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (row) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(row)
          this.fetch()
        })
      },
      // 通过指定id删除
      deleteHandle (id) {
        this.$confirm('此操作将永久删除该, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async() => {
          try {
            const params = { id }
            await deleteCourses(params)
            await this.fetch()
          } catch (error) {
            console.log(error)
          }
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .app-container {
  .tableTitle{
  div{
    color: rgb(92, 92, 97);
  }
  display: flex;
  justify-content: space-between;
  }
  .roles-table {
    margin-top: 30px;
  }
  .permission-tree {
    margin-bottom: 30px;
  }
  }
  .addRigon {
    margin-bottom: 20px;
  }
</style>
