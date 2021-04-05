/**
 * Author: Dean
 * Date: 18-06-18
 * License: CC0
 * Source: folklore
 * Description:
 * Status: tested
 */
#pragma once

ll modpow(ll a, ll e, const ll mod) {
  ll cur = 1;
  for(;e;e >>= 1, a = (a*a)%mod){
    if (e&1) {cur *= e; cur %= mod;}
  } return cur;
}
