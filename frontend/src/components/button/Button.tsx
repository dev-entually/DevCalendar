import React from 'react';
import styled from 'styled-components';

interface ButtonProps {
  size?: 'small' | 'default' | 'large';
}

export const Button = styled.button<ButtonProps>`
  text-align: center;
  font-size: ${props => {
    if (props.size === 'small') return '12px';
    if (props.size === 'default') return '14px';
    if (props.size === 'large') return '16px';
  }};
  background-color: cornflowerblue;
  color: white;
  padding: 8px 12px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  &:hover {
    filter: brightness(0.9);
  }
  &:active {
    box-shadow: inset 5px 5px 10px rgba(0, 0, 0, 0.1);
  }
`;

Button.defaultProps = {
  size: 'default',
}
