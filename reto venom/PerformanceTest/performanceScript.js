import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    stages: [
        { duration: '30s', target: 10 }, // Ramp-up to 10 users
        { duration: '1m', target: 50 },  // Steady load at 50 users
        { duration: '30s', target: 10 }, // Ramp-down to 10 users
    ],
};

const BASE_URL = 'https://petstore.swagger.io/v2';

export default function () {
    let res = http.get(`${BASE_URL}/pet/findByStatus?status=available`);
    
    check(res, {
        'is status 200': (r) => r.status === 200,
        'response time < 500ms': (r) => r.timings.duration < 500,
    });
    
    sleep(1);
}

// Additional Load Test for Creating a Pet
export let createPetOptions = {
    stages: [
        { duration: '20s', target: 5 },  // Ramp-up to 5 users
        { duration: '40s', target: 20 }, // Steady load at 20 users
        { duration: '20s', target: 5 },  // Ramp-down to 5 users
    ],
};

export function createPetTest() {
    let payload = JSON.stringify({
        id: 12345,
        name: "TestPet",
        status: "available"
    });
    
    let params = {
        headers: { "Content-Type": "application/json" },
    };
    
    let res = http.post(`${BASE_URL}/pet`, payload, params);
    
    check(res, {
        'is status 200': (r) => r.status === 200,
        'response contains pet name': (r) => JSON.parse(r.body).name === "TestPet",
    });
    
    sleep(1);
}
