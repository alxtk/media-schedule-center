Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext', '/webjars/extjs/4.2.0/');
Ext.require([
    'Ext.Msg'
]);

Ext.onReady(function(){
    Ext.Msg.alert('Приветствие','Hello World');
});