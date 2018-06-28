'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
		'demo.services' ]);
demoApp.constant("CONSTANTS", {
		getItemByIdUrl : "http://localhost:8080/stockItem/",
		//getAllItems
		getStockStatusItems : "http://localhost:8080/stockItem/list",
		getItemNames : "http://localhost:8080/stockItem/names",
		getItemSizes : "http://localhost:8080/stockItem/sizes/",
		saveItem : "http://localhost:8080/stockItem", 
		addTempItem : "http://localhost:8080/stockItem/addTempItem",
		getCustomerAccounts : "http://localhost:8080/account",
		createAccount : "http://localhost:8080/account",
		createSite : "http://localhost:8080/site",
		addIssuedItem : "http://localhost:8080/issued",
		getAccountNames : "http://localhost:8080/account/names",
		saveIssuedItem : "http://localhost:8080/issued",
		getAccountFatherNames : "http://localhost:8080/account/fathernames/",
		getItemExcessQuantity : "http://localhost:8080/stockItem/quantity/",
		saveReceivedItem : "http://localhost:8080/received",
		getIssuedRegister : "http://localhost:8080/issued/register?startDate=sdate&endDate=edate&partyName=pname&fatherName=fname&itemName=iname",
		getReceivedRegister : "http://localhost:8080/received/register?startDate=sdate&endDate=edate&partyName=pname&fatherName=fname&itemName=iname",
		getStockItemList : "http://localhost:8080/stockItem/stocklist",
		getSpecificData : "http://localhost:8080/stockItem/specificItem/plate",
		getPendencyReport : "http://localhost:8080/pendency/report?partyName=pname&fatherName=fname&itemName=iname&size=isize&site=isite",
		getdailyTransactions : "http://localhost:8080/transaction/fdate/tdate?itemName=iname&partyName=pname&fatherName=fname&size=isize&site=isite",
		saveAgreement : "http://localhost:8080/agreement",
		getItemSites : "http://localhost:8080/site",
		getIssuedAccountNames : "http://localhost:8080/issued/partynames",
		getIssuedAccountFatherNames : "http://localhost:8080/issued/fathernames/",
		getIssuedItemSites : "http://localhost:8080/issued/sites/",
		getIssuedItemNames : "http://localhost:8080/issued/itemnames",
		getIssuedItemSizes :"http://localhost:8080/issued/itemsize/"
});


