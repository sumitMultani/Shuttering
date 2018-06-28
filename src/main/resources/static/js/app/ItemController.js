'use strict'

var module = angular.module('demo.controllers', []);
module.controller("ItemController", [ "$scope", "ItemService",
		function($scope, ItemService, $window) {
	 
			$scope.Items = [];
			$scope.IssuedItems = [];
			$scope.ReceivedItems = [];
			$scope.quantity = "";
			$scope.itemRateSettings = [];
			 
			
			$scope.itemScreen = false;
		    $scope.toggleItemScreen = function() {
		        $scope.itemScreen = !$scope.itemScreen;
		        $scope.breakageScreen = false;
		        $scope.itemRateSettings = [];
		    };
		    
		    $scope.breakageScreen = false;
		    $scope.toogleBreakageScreen = function() {
		    	$scope.itemScreen = false;
		        $scope.breakageScreen = !$scope.breakageScreen;
		        $scope.itemRateSettings = [];
		    };
			//$scope.issuedRegisterItems = [];
			$scope.Add = function() {
				// Add the new item to the Array.
				var item = {};
				item.itemName = $scope.itemDto.itemName;
				item.length = $scope.itemDto.length;
				item.width = $scope.itemDto.width;
				item.squareFeet = $scope.itemDto.squareFeet;
				item.rate = $scope.itemDto.rate;
				item.per = $scope.itemDto.per;
				item.breakageCharges = $scope.itemDto.breakageCharges;
				item.stock = $scope.itemDto.stock;
				item.rentPerDay = $scope.itemDto.rentPerDay;
				$scope.Items.push(item);

				// Clear the TextBoxes.
				$scope.itemDto.itemName = "";
				$scope.itemDto.length = "";
				$scope.itemDto.width = "";
				$scope.itemDto.squareFeet = "";
				$scope.itemDto.rate = "";
				$scope.itemDto.per = "";
				$scope.itemDto.stock = "";
				$scope.itemDto.breakageCharges = "";
				$scope.itemDto.rentPerDay = "";
			};

			// perform action on double click.
			$scope.doubleClick = function(itemName) {
				ItemService.getSpecificData(itemName).then(function(value) {
					$scope.items = value.data;
				});
			};
			
			// Add issued Item
			$scope.AddIssuedItem = function() {
				// Add the new item to the Array.
				var itemIssued = {};
				//itemIssued.issuedDate = $scope.itemIssuedDto.issuedDate;
				itemIssued.issuedDate = convertDate($scope.itemIssuedDto.issuedDate);
				itemIssued.transactionType = $scope.itemIssuedDto.transactionType;
				itemIssued.challanNo = $scope.itemIssuedDto.challanNo;
				itemIssued.partyName = $scope.itemIssuedDto.partyName;
				itemIssued.fatherName = $scope.itemIssuedDto.fatherName;
				itemIssued.itemName = $scope.itemIssuedDto.itemName;
				itemIssued.size = $scope.itemIssuedDto.size;
				itemIssued.quantity = $scope.itemIssuedDto.quantity;
				itemIssued.site = $scope.itemIssuedDto.site;
				itemIssued.mobile = $scope.itemIssuedDto.mobile;
				itemIssued.remarks = $scope.itemIssuedDto.remarks;
				$scope.IssuedItems.push(itemIssued);
				// Clear the TextBoxes.
				$scope.itemIssuedDto.transactionType = "";
				$scope.itemIssuedDto.itemName = "";
				$scope.itemIssuedDto.size = "";
				$scope.itemIssuedDto.quantity = "";
				$scope.itemIssuedDto.mobile = "";
				$scope.itemIssuedDto.remarks = "";
				$scope.itemIssuedDto.site.siteName = "";
			};
			
			// item rate Setting
			$scope.AddItemRateSetting = function() {
				// Add the new item to the Array.
				var itemRateSetting = {};
				itemRateSetting.date = $scope.agreementDto.date;
				itemRateSetting.aggrementNo = $scope.agreementDto.aggrementNo;
				itemRateSetting.partyName = $scope.agreementDto.partyName;
				itemRateSetting.fatherName = $scope.agreementDto.fatherName;
				itemRateSetting.siteName = $scope.agreementDto.siteName;
				itemRateSetting.itemName = $scope.agreementDto.itemName;
				itemRateSetting.length = $scope.agreementDto.length;
				itemRateSetting.rate = $scope.agreementDto.rate;
				itemRateSetting.per = $scope.agreementDto.per;
				itemRateSetting.rentPerDay = $scope.agreementDto.rentPerDay;
				
//				itemRateSetting.itemNameBreakage = $scope.agreementDto.itemNameBreakage;
//				itemRateSetting.itemSizeBreakage = $scope.agreementDto.itemSizeBreakage;
//				itemRateSetting.damageChargesPerPc = $scope.agreementDto.damageChargesPerPc;
				$scope.itemRateSettings.push(itemRateSetting);
				// Clear the TextBoxes.
			     $scope.agreementDto.agreementNo = "";
			     $scope.agreementDto.partyName= "";
			     $scope.agreementDto.fatherName= "";
			     $scope.agreementDto.site= "";
				 $scope.agreementDto.itemName= "";
				 $scope.agreementDto.size= "";
				 $scope.agreementDto.rate= "";
				 $scope.agreementDto.per= "";
				 $scope.agreementDto.rentPerDay = "";
				 $scope.agreementDto.damageRate= "";
			};
			
			$scope.breakageItemRateSetting = function() {
				// Add the new item to the Array.
				var itemRateSetting = {};
				itemRateSetting.date = $scope.agreementDto.date;
				itemRateSetting.aggrementNo = $scope.agreementDto.aggrementNo;
				itemRateSetting.partyName = $scope.agreementDto.partyName;
				itemRateSetting.fatherName = $scope.agreementDto.fatherName;
				itemRateSetting.siteName = $scope.agreementDto.siteName;
//				itemRateSetting.itemName = $scope.agreementDto.itemName;
//				itemRateSetting.length = $scope.agreementDto.length;
//				itemRateSetting.rate = $scope.agreementDto.rate;
//				itemRateSetting.per = $scope.agreementDto.per;
//				itemRateSetting.rentPerDay = $scope.agreementDto.rentPerDay;
				
				itemRateSetting.itemNameBreakage = $scope.agreementDto.itemNameBreakage;
				itemRateSetting.itemSizeBreakage = $scope.agreementDto.itemSizeBreakage;
				itemRateSetting.damageChargesPerPc = $scope.agreementDto.damageChargesPerPc;
				$scope.itemRateSettings.push(itemRateSetting);
				// Clear the TextBoxes.
			     $scope.agreementDto.agreementNo = "";
			     $scope.agreementDto.partyName= "";
			     $scope.agreementDto.fatherName= "";
			     $scope.agreementDto.site= "";
				 $scope.agreementDto.itemName= "";
				 $scope.agreementDto.length= "";
				 $scope.agreementDto.rate= "";
				 $scope.agreementDto.per= "";
				 $scope.agreementDto.rentPerDay = "";
				 $scope.agreementDto.damageRate= "";
			};
			
			 
			// Add Received Items
			$scope.AddReceivedItem = function() {
				// Add the new item to the Array.
				var itemReceived = {};
				itemReceived.receivedDate = convertDate($scope.itemReceivedDto.receivedDate);
				itemReceived.transactionType = $scope.itemReceivedDto.transactionType;
				itemReceived.challanNo = $scope.itemReceivedDto.challanNo;
				itemReceived.partyName = $scope.itemReceivedDto.partyName;
				itemReceived.fatherName = $scope.itemReceivedDto.fatherName;
				itemReceived.itemName = $scope.itemReceivedDto.itemName;
				itemReceived.size = $scope.itemReceivedDto.size;
				itemReceived.quantity = $scope.itemReceivedDto.quantity;
				itemReceived.excessQuantity = $scope.itemReceivedDto.excessQuantity;
				itemReceived.breakage = $scope.itemReceivedDto.breakage;
				itemReceived.shortage = $scope.itemReceivedDto.shortage;
				itemReceived.site = $scope.itemReceivedDto.site;
				itemReceived.mobile = $scope.itemReceivedDto.mobile;
				itemReceived.remarks = $scope.itemReceivedDto.remarks;
				$scope.ReceivedItems.push(itemReceived);

				// Clear the TextBoxes.
				$scope.itemReceivedDto.transactionType = "";
				$scope.itemReceivedDto.itemName = "";
				$scope.itemReceivedDto.size = "";
				$scope.itemReceivedDto.quantity = "";
				$scope.itemReceivedDto.excessQuantity = "";
				$scope.itemReceivedDto.breakage = "";
				$scope.itemReceivedDto.shortage = "";
				$scope.itemReceivedDto.site = "";
				$scope.itemReceivedDto.mobile = "";
				$scope.itemReceivedDto.remarks = "";
			};

			
			// remove item froom list
			$scope.Remove = function(index) {
				// Find the record using Index from Array.
				var name = $scope.Items[index].itemName;
				var val = confirm("Do you want to remove.")

				if (val == true) {
					// Remove the item from Array using Index.
					$scope.Items.splice(index, 1);
				}
			};

			// save Item or Item List
			$scope.saveItem = function() {
				ItemService.saveItem($scope.Items).then(function() {
					console.log("Saving Items.");
					$scope.Items = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			// Add Item button functionality.
			$scope.addTempItem = function(item) {
				console.log(item);
				$scope.itemDto.push(item);
				// Clear the TextBoxes.
				$scope.itemName = "";
				$scope.length = "";

			};

			// calculate sq feet and rentPerDay
			$scope.calculateSqFt = function(x, y) {
				$scope.itemDto.squareFeet = x * y;
			};

			$scope.calculateRentPerDay = function(rate) {
				$scope.agreementDto.rentPerDay = rate;
				$scope.itemDto.rentPerDay = rate;
			};
			
			$scope.calculateItemRentPerDay = function(rate) {
				$scope.itemDto.rentPerDay = rate;
			};

			// list items
			$scope.listItem = function() {
				ItemService.getStockStatusItems().then(function(value) {
					$scope.items = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});

				$scope.itemDto = {
					itemId : null,
					itemName : null,
					stock : null
				};
			};

			 
			// total stock item list
			$scope.listStockItem = function() {
				ItemService.getStockItemList().then(function(value) {
					$scope.items = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});

				$scope.itemDto = {
					itemId : null,
					itemName : null,
					stock : null
				};
			};
			
			//issued Register
			$scope.issuedRegister = function(startDate, endDate, partyName, fatherName, itemName) {
				
				if(startDate != null && startDate != undefined)
					startDate = convertDate(startDate);
				if(endDate != null && endDate != undefined)
					endDate = convertDate(endDate);
				
				ItemService.getIssuedRegister(startDate, endDate, partyName, fatherName, itemName).then(function(value) {
					$scope.issuedRegisterItems = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});

				$scope.itemDto = {
					itemId : null,
					itemName : null,
					stock : null
				};
			};
			
			// get Received register data
			$scope.receivedRegister = function(fromDate, toDate, partyName, fatherName, itemName) {
				ItemService.getReceivedRegister(fromDate, toDate, partyName, fatherName, itemName).then(function(value) {
					$scope.receivedRegisterItems = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});

				$scope.itemDto = {
					itemId : null,
					itemName : null,
					stock : null
				};
			};
			
			// get pendency report
			$scope.pendencyReport = function(partyName, fatherName, itemname, size, site) {
				ItemService.getPendencyReport(partyName, fatherName, itemname, size, site).then(function(value) {
					$scope.pendencyReportItems = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
 
			};
			
			// get daily Transactions
			$scope.dailyTransactions = function(fromDate, toDate, partyName, fatherName, itemname, size, site) {
				fromDate = convertDate(fromDate);
				toDate = convertDate(toDate);
				ItemService.getDailyTransactions(fromDate, toDate, partyName, fatherName, itemname, size, site).then(function(value) {
					$scope.dailyTransactionItems = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
 
			};
			
			// get all Customer Accounts
			$scope.getCustomerAccounts = function() {
				ItemService.getCustomerAccounts().then(function(value) {
					$scope.accounts = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			//	get Stock status
			$scope.getStockStatusItems = function() {
				ItemService.getStockStatusItems().then(function(value) {
					$scope.items = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			 
			//get AccountNames
			$scope.getAccountNames = function() {
				ItemService.getAccountNames().then(function(value) {
					$scope.accountNames = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			//get Issued Account names
			$scope.getIssuedAccountNames = function() {
				ItemService.getIssuedAccountNames().then(function(value) {
					$scope.accountNames = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			
			//get account Father name
			$scope.getAccountFatherNames = function(partyNamme) {
				ItemService.getAccountFatherNames(partyNamme).then(function(value) {
					$scope.accountFatherNames = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			// get Issued Account father names based on party name
			$scope.getIssuedAccountFatherNames = function(partyName) {
				ItemService.getIssuedAccountFatherNames(partyName).then(function(value) {
					$scope.accountFatherNames = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			
			// get Item Names
			$scope.getItemNames = function() {
				ItemService.getItemNames().then(function(value) {
					$scope.itemNames = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			// get Issued Item names
			$scope.getIssuedItemNames = function() {
				ItemService.getIssuedItemNames().then(function(value) {
					$scope.itemNames = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			// get Item Sizes
			$scope.getItemSizes = function(itemName) {
				ItemService.getItemSizes(itemName).then(function(value) {
					$scope.itemSizes = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			//get Issued item sizes
			$scope.getIssuedItemSizes = function(itemName) {
				ItemService.getIssuedItemSizes(itemName).then(function(value) {
					$scope.itemSizes = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			
			// get Item Sites
			$scope.getItemSites = function() {
				ItemService.getItemSites().then(function(value) {
					$scope.sites = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			
			// get Issued Item Sites
			$scope.getIssuedItemSites = function(partyname, fathername) {
				ItemService.getIssuedItemSites(partyname, fathername).then(function(value) {
					$scope.sites = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			// save Account
			$scope.createAccount = function(account) {
				ItemService.createAccount(account).then(function() {
					console.log("Saving Items.");
					$scope.accountDto = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			// save Account
			$scope.createSite = function(site) {
				ItemService.createSite(site).then(function() {
					console.log("Saving Items.");
					$scope.siteDto = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			// save issued item data
			$scope.addIssuedItem = function(issuedItem) {
				ItemService.addIssuedItem(issuedItem).then(function() {
					console.log("Saved Issued Items.");
					$scope.IssuedItems = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			// save Agreement
			$scope.saveAgreement = function() {
				ItemService.saveAgreement($scope.itemRateSettings).then(function() {
					console.log("Saved Agreement.");
					$scope.itemRateSettings = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			// save Issued Item or item List.
			$scope.saveIssuedItem = function() {
				ItemService.saveIssuedItem($scope.IssuedItems).then(function() {
					console.log("Saved issued Items.");
					$scope.IssuedItems = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			
			//saveReceivedItem
			$scope.saveReceivedItem = function() {
				ItemService.saveReceivedItem($scope.ReceivedItems).then(function() {
					console.log("Saved Received Items.");
					$scope.ReceivedItems = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			//get Excess Quantity
			$scope.getItemExcessQuantity = function(itemName) {
				ItemService.getItemExcessQuantity(itemName).then(function(value) {
					$scope.itemIssuedDto.excessQuantity = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			$scope.editItem = function (item) {
			    item.editing = true;
			}

			$scope.doneEditing = function (item) {
			    item.editing = false;
			};
			
			//get received item Excess Quantity
			$scope.getReceivedItemExcessQuantity = function(itemName) {
				ItemService.getItemExcessQuantity(itemName).then(function(value) {
					$scope.itemReceivedDto.excessQuantity = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			// conert date into yyyy-mm-d format
			function convertDate(str) {
			    var date = new Date(str),
			        mnth = ("0" + (date.getMonth()+1)).slice(-2),
			        day  = ("0" + date.getDate()).slice(-2);
			    return [ date.getFullYear(), mnth, day ].join("-");
			}
		} ]);