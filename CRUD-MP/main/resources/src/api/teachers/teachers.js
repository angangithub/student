import request from '@/utils/request'

//  分页查询列表
export function queryForPage(params) {
    console.log('分页查询列表', params)
    return request({
        url: 'teachers/queryForPage',
        method: 'get',
        params
    })
}

//  保存表单
export function saveTeachers(data) {
    console.log('保存表单', data)
    return request({
        url: 'teachers/saveTeachers',
        method: 'post',
        data
    })
}

// 修改表单
export function updateTeachers(data) {
    console.log('修改表单', data)
    return request({
        url: 'teachers/updateTeachers',
        method: 'put',
        data
    })
}

// 通过指定id删除
export function deleteTeachers(params) {
    console.log('通过指定id删除', params)
    return request({
        url: 'teachers/deleteTeachers',
        method: 'delete',
        params
    })
}