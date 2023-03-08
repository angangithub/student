import request from '@/utils/request'

//  分页查询列表
export function queryForPage(params) {
    console.log('分页查询列表', params)
    return request({
        url: 'enrollments/queryForPage',
        method: 'get',
        params
    })
}

//  保存表单
export function saveEnrollments(data) {
    console.log('保存表单', data)
    return request({
        url: 'enrollments/saveEnrollments',
        method: 'post',
        data
    })
}

// 修改表单
export function updateEnrollments(data) {
    console.log('修改表单', data)
    return request({
        url: 'enrollments/updateEnrollments',
        method: 'put',
        data
    })
}

// 通过指定id删除
export function deleteEnrollments(params) {
    console.log('通过指定id删除', params)
    return request({
        url: 'enrollments/deleteEnrollments',
        method: 'delete',
        params
    })
}