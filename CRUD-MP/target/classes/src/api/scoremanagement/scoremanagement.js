import request from '@/utils/request'

//  分页查询列表
export function queryForPage(params) {
    console.log('分页查询列表', params)
    return request({
        url: 'scoremanagement/queryForPage',
        method: 'get',
        params
    })
}

//  保存表单
export function saveScoreManagement(data) {
    console.log('保存表单', data)
    return request({
        url: 'scoremanagement/saveScoreManagement',
        method: 'post',
        data
    })
}

// 修改表单
export function updateScoreManagement(data) {
    console.log('修改表单', data)
    return request({
        url: 'scoremanagement/updateScoreManagement',
        method: 'put',
        data
    })
}

// 通过指定id删除
export function deleteScoreManagement(params) {
    console.log('通过指定id删除', params)
    return request({
        url: 'scoremanagement/deleteScoreManagement',
        method: 'delete',
        params
    })
}