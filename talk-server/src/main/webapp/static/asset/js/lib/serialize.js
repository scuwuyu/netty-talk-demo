$.fn.serializeObject = function () {
    var serializeObj = {};
    var array = this.serializeArray();
    var str = this.serialize();
    $(array).each(function () {
        if (serializeObj[this.name]) {
            if ($.isArray(serializeObj[this.name])) {
                serializeObj[this.name].push(this.value);
            } else {
                serializeObj[this.name] = [serializeObj[this.name], this.value];
            }
        } else {
            if ($('.contentTable textarea[id=' + this.name + ']').length > 0) {
                if ($.trim(this.value) != '') {
                    try {
                        serializeObj[this.name] = $.parseJSON(this.value);
                    } catch (e) {
                        alert('参数（' + this.name + '）不是一个标准的JSON格式数据')
                    }
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        }
    });
    return serializeObj;
};

$.fn.serializeForm = function (httpMethod) {
    if(httpMethod.toLowerCase()=== 'get'){
        return $(this).serialize();
    }

    return JSON.stringify($(this).serializeObject());
}

$.extend({
    serializeJson:function (jsonObj, httpMethod) {
        if(httpMethod.toLowerCase()=== 'get'){
            return jsonObj;
        }

        return JSON.stringify(jsonObj);
    },
    getContentType: function (httpMethod) {
        if(httpMethod.toLowerCase()=== 'get'){
            return '';
        }

        return "application/json;charset=UTF-8";
    }
});

