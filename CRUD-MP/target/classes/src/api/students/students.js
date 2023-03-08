import request from '@/utils/request'

//  分页查询列表
export function queryForPage(params) {
    console.log('分页查询列表', params)
    return request({
        url: 'students/queryForPage',
        method: 'get',
        params
    })
}

//  保存表单
export function saveStudents(data) {
    console.log('保存表单', data)
    return request({
        url: 'students/saveStudents',
        method: 'post',
        data
    })
}

// 修改表单
export function updateStudents(data) {
    console.log('修改表单', data)
    return request({
        url: 'students/updateStudents',
        method: 'put',
        data
    })
}

// 通过指定id删除
export function deleteStudents(params) {
    console.log('通过指定id删除', params)
    return request({
        url: 'students/deleteStudents',
        method: 'delete',
        params
    })
}