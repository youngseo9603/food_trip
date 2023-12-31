import { localAxios } from '../utils/http-commons';
import { ref } from 'vue';
const wishAPI = localAxios();

const addWish = (info, success, fail) => {
	var wish = ref({});
	wish.value.address = info.address;
	wish.value.placeName = info.placeName;
	wish.value.category = info.category;

	wishAPI
		.post(`/wish?memberIndex=${info.memberIndex}`, wish.value)
		.then(success)
		.catch(fail);
};

const getWishList = (memberIndex, success, fail) => {
	console.log(memberIndex);
	wishAPI.get(`/wish?memberIndex=${memberIndex}`).then(success).catch(fail);
};

const removeWish = (info, success, fail) => {
	console.log(info);
	wishAPI
		.delete(`/wish?memberIndex=${info.memberIndex}&wishIndex=${info.wishIndex}`)
		.then(success)
		.then(fail);
};

export default { addWish, getWishList, removeWish };
